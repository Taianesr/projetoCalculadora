package br.com.desafioCompasso.calculadora.modelMapper;


import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;

@Configuration

public class ModelMapperConfigMedicamento {
	@Bean
	public ModelMapper modelMapperMed() {
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(MedicamentoEntity.class, MedicamentoDto.class).addMappings(mapper -> {
			//nao sei se devo usar 
			mapper.map(src -> src.getInfoSobra(), MedicamentoDto::setInfoSobra);
			mapper.map(src -> src.getConcentracaoInicial(), MedicamentoDto::setConcentracaoInicial);
			mapper.map(src -> src.getGrupoMedicamento().getId(), MedicamentoDto::setIdGrupoMedicamento);
			mapper.map(src -> src.getLaboratorio().getId(), MedicamentoDto::setIdLaboratorio);
			mapper.map(src -> src.getNome(), MedicamentoDto::setNome);
			mapper.map(src -> src.getEmbalagemApresentada(), MedicamentoDto::setEmbalagemApresentada);
			mapper.map(src -> src.getQuantidadeApresentacao(), MedicamentoDto::setQuantidadeApresentacao);
			mapper.map(src -> src.getUnidadeMedida(), MedicamentoDto::setUnidadeMedida);
			mapper.map(src -> src.getInfoObservacao(), MedicamentoDto::setInfoObservacao);
			mapper.map(src -> src.getInfoSobra(), MedicamentoDto::setInfoSobra);
			mapper.map(src -> src.getInfoTempoAdministracao(), MedicamentoDto::setInfoTempoAdministracao);
	
			
		});

   return modelMapper;


	}

}
