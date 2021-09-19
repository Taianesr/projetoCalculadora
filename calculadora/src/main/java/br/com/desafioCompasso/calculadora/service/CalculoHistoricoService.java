package br.com.desafioCompasso.calculadora.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.controller.form.CalculoHistoricoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfig;
import br.com.desafioCompasso.calculadora.repository.CalculoHistoricoRepository;

@Service
public class CalculoHistoricoService {

	@Autowired
	private CalculoHistoricoRepository calculoHistoricoRepository;

	@Autowired
	private ModelMapperConfig modelMapper;

	// revisar metodo

	public CalculoHistoricoDto criar(CalculoHistoricoForm calcHistoricoForm) throws ServiceException {

		CalculoHistoricoEntity calcHistorico = modelMapper.modelMapper().map(calcHistoricoForm,
				CalculoHistoricoEntity.class);
		calculoHistoricoRepository.save(calcHistorico);

		return modelMapper.modelMapper().map(calcHistorico, CalculoHistoricoDto.class);

	}
	
	public CalculoHistoricoDto listar(Long id, Date dataIni, Date dataFim) {
		
		CalculoHistoricoEntity calcHistorico= calculoHistoricoRepository.findDataIniDataFim(id, dataIni, dataFim)
				.orElseThrow(() -> new NotFoundException("Não encontrado calculo entre as datas!"));
		
		return  modelMapper.modelMapper().map(calcHistorico, CalculoHistoricoDto.class);
		
		
	}
	
	
	
	
	

}
