package br.com.desafioCompasso.calculadora.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoDto;
import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.controller.form.CalculoHistoricoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;
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

	public CalculoHistoricoDto criar(CalculoHistoricoForm calcHistoricoForm) throws NotFoundException {

		MedicamentoEntity med = medRepository.findById(calcHistoricoForm.getIdMedicamento())
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento pelo id!"));

		ViaAdministracaoEntity viaAdm = viaAdmRepository.findById(calcHistoricoForm.getIdViaAdministracao())
				.orElseThrow(() -> new NotFoundException("Não encontrado a via administracao pelo id!"));


		CalculoHistoricoEntity calcHistorico = new CalculoHistoricoEntity(calcHistoricoForm.getNomeUsuario(), med,
				viaAdm, calcHistoricoForm.getQuantidadePrescrita());
		
		CalculoHistoricoDto dto= modelMapper.modelMapperCalcHistorico().map(calcHistorico, CalculoHistoricoDto.class);
		
		StringBuilder calcDto = listarInfo(med, viaAdm, calcHistorico);
		
		String calcDto2= calcDto.toString();
		
		calcHistorico.setResultadosJson(calcDto2);
		
		
		calculoHistoricoRepository.save(calcHistorico);

		return dto;

	}
	

	// retorna somente um dto

	public CalculoHistoricoDto listar(Long id, Date dataIni, Date dataFim) throws NotFoundException {

		CalculoHistoricoEntity calcHistorico = calculoHistoricoRepository.findDataIniDataFim(id, dataIni, dataFim)
				.orElseThrow(() -> new NotFoundException("Não encontrado calculo entre as datas!"));

		return modelMapper.modelMapperCalcHistorico().map(calcHistorico, CalculoHistoricoDto.class);

	}
	
	

	// resultados json
	public StringBuilder listarInfo(MedicamentoEntity med, ViaAdministracaoEntity viaAdm, CalculoHistoricoEntity calcHistorico) {

		List<DiluicaoConfiguracaoEntity> lstDiluicaoConf = diluicaoConfRepository
				.findByDiluicaoConfPKMedicamentoId(med.getId());

		List<Integer> lstSequencias = new ArrayList<>();

		for (int i = 0; i < lstDiluicaoConf.size(); i++) {
			lstSequencias.add(lstDiluicaoConf.get(i).getDiluicaoConfPK().getSequencia());
		}
		
		

		DiluicaoConfiguracaoEntityPK diluicaoConfEntityPK = new DiluicaoConfiguracaoEntityPK(med, viaAdm,
				lstSequencias.get(0));
		DiluicaoConfiguracaoEntityPK diluicaoConfEntityPK2 = new DiluicaoConfiguracaoEntityPK(med, viaAdm,
				lstSequencias.get(1));
		
		

		DiluicaoConfiguracaoEntity diluicao = diluicaoConfRepository.findByDiluicaoConfPK(diluicaoConfEntityPK)
				.orElseThrow(() -> new NotFoundException("Não encontrado a diluicao configuracao pelo id!"));

		DiluicaoConfiguracaoEntity rediluicao = diluicaoConfRepository.findByDiluicaoConfPK(diluicaoConfEntityPK2)
				.orElseThrow(() -> new NotFoundException("Não encontrado a diluicao configuracao pelo id!"));
		
		
		       //calculo 
		  
		       BigDecimal var1= calcHistorico.getQuantidadeApresentada();
		        
		     
		        
		        
		        BigDecimal var2= diluicao.getQuantidadeAdicionada();
		        
				BigDecimal resultadoPrimeiraDiluicao= var1.divide(var2);
				
				
				
				BigDecimal ml = BigDecimal.valueOf(1.0);
	
				
				BigDecimal p1= var1.multiply(ml);
				
				
				BigDecimal result= p1.divide(rediluicao.getConcentracao());
				
				
				
		

		String infoAdministracao= "Resultado da aspiração " + result;
		//List<String> lstMensagem = new ArrayList<>();
		List<String> infoList = new ArrayList<>();
		
		StringBuilder msg= new StringBuilder();
		
		

		msg.append("Diluir pó com " + diluicao.getQuantidadeAdicionada() + "e misturar");
		
		if (diluicao.getQuantidadeAdicionada()== null) {
			msg.append("Pronto para uso");
			
		}
		
		

		if (rediluicao.getQuantidadeAspirada()==null && rediluicao.getQuantidadeAdicionada()!=null) {
			msg.append("completar com " + rediluicao.getQuantidadeAdicionada());

		} else {
			if (rediluicao.getQuantidadeAspirada() !=null && rediluicao.getQuantidadeAdicionada() != null) {
				msg.append("Em seringa de 20 ml aspirar" + rediluicao.getQuantidadeAspirada()
						+ "do pó diluido e completar com " + rediluicao.getQuantidadeAdicionada());
			}
			if (rediluicao.getQuantidadeAspirada() == null && rediluicao.getQuantidadeAdicionada() == null) {
				msg.append("pronto para uso");
			}

		}

		infoList.add("É necessario adicionar permeabilização ao resultado");

		CalculoDto calcDto = new CalculoDto();
		//calcDto.setPassosAdministracao(lstMensagem);
		calcDto.setInfoList(infoList);
		calcDto.setInfoAdministracao(infoAdministracao);

		return msg;

	}
	
	


}
