package br.com.desafioCompasso.calculadora.service;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.DiluicaoConfiguracaoDto;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigDiluicao;
import br.com.desafioCompasso.calculadora.repository.DiluicaoConfiguracaoRepository;

@Service
public class DiluicaoConfiguracaoService {
	
	@Autowired
	private DiluicaoConfiguracaoRepository diluicaoConfRepository;
	
	@Autowired
	private ModelMapperConfigDiluicao modelMapper;

	public List<DiluicaoConfiguracaoDto> listar() {
		
		List<DiluicaoConfiguracaoEntity> lstDiluicaoConf= diluicaoConfRepository.findAll();
		
		TypeToken<List<DiluicaoConfiguracaoDto>> typeToken = new TypeToken<>() {};

		List<DiluicaoConfiguracaoDto> lstDiluicaoConfDtos = modelMapper.modelMapperDiluicaoConf().map(lstDiluicaoConf, typeToken.getType());
		return lstDiluicaoConfDtos;
		
	}
	

	public void excluir(Long medId, Long viaAdmId, int sequencia) {
		DiluicaoConfiguracaoEntity diluicaoConf = diluicaoConfRepository.findByMedicamentoIdAndViaAdministracaoIdAndSequencia(medId, viaAdmId, sequencia)
				.orElseThrow(() -> new NotFoundIdException("Não encontrada a diluicao configuracao com esse id!"));
		
		diluicaoConfRepository.deleteByMedicamentoIdAndViaAdministracaoIdAndSequencia(diluicaoConf.getMedicamentoId(), diluicaoConf.getViaAdministracaoId(), diluicaoConf.getSequencia());
		
	}



	
	

}
