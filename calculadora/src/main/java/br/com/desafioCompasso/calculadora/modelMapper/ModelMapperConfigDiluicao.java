package br.com.desafioCompasso.calculadora.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.desafioCompasso.calculadora.controller.dto.DiluicaoConfiguracaoDto;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;

@Configuration
public class ModelMapperConfigDiluicao {

	@Bean
	public ModelMapper modelMapperDiluicaoConf() {
		
		
		var modelMapper= new ModelMapper();
		
		
		modelMapper.createTypeMap(DiluicaoConfiguracaoEntity.class, DiluicaoConfiguracaoDto.class).addMappings(mapper -> {
			 mapper.map(src -> src.getDiluicaoConfPK().getMedicamento().getId(),   DiluicaoConfiguracaoDto::setIdMedicamento);
			 mapper.map(src -> src.getDiluicaoConfPK().getViaAdministracao().getId(),   DiluicaoConfiguracaoDto::setIdViaAdministracao);
			mapper.map(src -> src.getDiluicaoConfPK().getSequencia(),   DiluicaoConfiguracaoDto::setSequencia);
			 mapper.map(src -> src.getQuantidadeAspirada(),   DiluicaoConfiguracaoDto::setQuantidadeAspirada);
			 mapper.map(src -> src.getQuantidadeAdicionada(),   DiluicaoConfiguracaoDto::setQuantidadeAdicionada);
			 mapper.map(src -> src.getConcentracao(),   DiluicaoConfiguracaoDto::setConcentracao);
			 mapper.map(src -> src.getDiluente(),   DiluicaoConfiguracaoDto::setDiluente);
			 mapper.map(src -> src.getModoPreparo(),   DiluicaoConfiguracaoDto::setModoPreparo);
			});
		
		modelMapper.validate();
		
		return modelMapper;
	}

	
}
