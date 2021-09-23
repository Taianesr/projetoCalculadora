package br.com.desafioCompasso.calculadora.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoDto;
import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.controller.form.CalculoHistoricoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigCalcHistorico;
import br.com.desafioCompasso.calculadora.repository.CalculoHistoricoRepository;
import br.com.desafioCompasso.calculadora.repository.DiluicaoConfiguracaoRepository;
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
	private DiluicaoConfiguracaoRepository diluicaoConfRepository;

	@Autowired
	private ModelMapperConfigCalcHistorico modelMapper;

	// revisar metodo

	public CalculoDto criar(CalculoHistoricoForm calcHistoricoForm) throws NotFoundIdException {

		MedicamentoEntity med = medRepository.findById(calcHistoricoForm.getIdMedicamento())
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento pelo id!"));

		ViaAdministracaoEntity viaAdm = viaAdmRepository.findById(calcHistoricoForm.getIdViaAdministracao())
				.orElseThrow(() -> new NotFoundIdException("Não encontrado a via administracao pelo id!"));

		CalculoHistoricoEntity calcHistorico = new CalculoHistoricoEntity(calcHistoricoForm.getNomeUsuario(), med,
				viaAdm, calcHistoricoForm.getQuantidadePrescrita());

		

		CalculoDto calcDto = listarInfo(med, viaAdm, calcHistorico);


		calculoHistoricoRepository.save(calcHistorico);
		

		return calcDto;

	}

	
	
	// retorna somente um dto

	public CalculoHistoricoDto listar(Long id, Date dataIni, Date dataFim) throws NotFoundException {

		CalculoHistoricoEntity calcHistorico = calculoHistoricoRepository.findDataIniDataFim(id, dataIni, dataFim)
				.orElseThrow(() -> new NotFoundException("Não encontrado calculo entre as datas!"));

		return modelMapper.modelMapperCalcHistorico().map(calcHistorico, CalculoHistoricoDto.class);

	}
	
	

	// resultados json
	public CalculoDto listarInfo(MedicamentoEntity med, ViaAdministracaoEntity viaAdm,
			CalculoHistoricoEntity calcHistorico) {

		List<DiluicaoConfiguracaoEntity> lstDiluicaoConf = diluicaoConfRepository
				.findByMedicamentoIdAndViaAdministracaoIdOrderBySequenciaAsc(med.getId(), viaAdm.getId());
		
		
		List<String> msgPassosAdministracao = new ArrayList<String>();
		List<String> infoList = new ArrayList<String>();
		String infoAdministracao= "";
		
		BigDecimal concentracaoFinal = BigDecimal.ZERO;

		
		
		// Pegar a concentracao do medicamento e atribuir a concentracao atual
		// (concentracaoAtual) TODO

		// BigDecimal concentracaoInicial = BigDecimal.ZERO;

		for (DiluicaoConfiguracaoEntity diluicaoConfiguracaoEntity : lstDiluicaoConf) {
			 msgPassosAdministracao.add(diluicaoConfiguracaoEntity.getModoPreparo());
			 concentracaoFinal= diluicaoConfiguracaoEntity.getConcentracao();
		}
		
	
		
		if (lstDiluicaoConf.isEmpty()) {
			msgPassosAdministracao.add("Pronto para uso");
			concentracaoFinal = med.getQuantidadeApresentacao();
		}

		
		infoList.add("Sobra "+ med.getInfoSobra() );
		infoList.add("Tempo de administracao: "+ med.getInfoTempoAdministracao());
		infoList.add( med.getInfoObservacao());
		
		
		// quando chegar aqui tu tenhga a concentracao do medicamento, ou da ultima
		// configuracao

		BigDecimal result = calcHistorico.getQuantidadePrescrita().divide(concentracaoFinal, 2, RoundingMode.HALF_UP);
		
		infoAdministracao = "Resultado da aspiração é" + result;
		
		
		
		CalculoDto calcDto= new CalculoDto(infoAdministracao, msgPassosAdministracao ,infoList);
		
		return calcDto;

	}

}
