package br.com.desafioCompasso.calculadora.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.controller.form.CalculoHistoricoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigCalcHistorico;
import br.com.desafioCompasso.calculadora.repository.CalculoHistoricoRepository;
import br.com.desafioCompasso.calculadora.repository.MedicamentoRepository;
import br.com.desafioCompasso.calculadora.repository.ViaAdministracaoRepository;

@Service
public class CalculoHistoricoService {

	@Autowired
	private CalculoHistoricoRepository calculoHistoricoRepository;

	@Autowired
	private ViaAdministracaoRepository viaAdmRepository;

	@Autowired
	private MedicamentoRepository medRepository;

	@Autowired
	private ModelMapperConfigCalcHistorico modelMapper;

	// revisar metodo

	public CalculoHistoricoDto criar(CalculoHistoricoForm calcHistoricoForm) throws NotFoundException {

		MedicamentoEntity med = medRepository.findById(calcHistoricoForm.getIdMedicamento())
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento pelo id!"));

		ViaAdministracaoEntity viaAdm = viaAdmRepository.findById(calcHistoricoForm.getIdViaAdministracao())
				.orElseThrow(() -> new NotFoundException("Não encontrado a via administracao pelo id!"));

		CalculoHistoricoEntity calcHistorico = new CalculoHistoricoEntity(calcHistoricoForm.getNomeUsuario(), med,
				viaAdm, calcHistoricoForm.getQuantidadePrescrita());

		calculoHistoricoRepository.save(calcHistorico);
		return modelMapper.modelMapperCalcHistorico().map(calcHistorico, CalculoHistoricoDto.class);

	}
	
	//retorna somente um dto

	public CalculoHistoricoDto listar(Long id, Date dataIni, Date dataFim) throws NotFoundException {

		CalculoHistoricoEntity calcHistorico = calculoHistoricoRepository.findDataIniDataFim(id, dataIni, dataFim)
				.orElseThrow(() -> new NotFoundException("Não encontrado calculo entre as datas!"));

		return modelMapper.modelMapperCalcHistorico().map(calcHistorico, CalculoHistoricoDto.class);

	}

}
