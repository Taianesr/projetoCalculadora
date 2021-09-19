package br.com.desafioCompasso.calculadora.modelMapper;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
@Configuration

public class ModelMapperConfigMedicamento {
	@Bean
	public ModelMapper modelMapper2() {
		
		
		var modelMapper2= new ModelMapper();
		
		//modelMapper2.createTypeMap(MedicamentoEntity.class, MedicamentoDto.class).<Long>addMapping(src -> src.getGrupoMedicamento().getId() , (dest,value) -> dest.setIdGrupoMedicamento( value));
		
		
		//modelMapper2.createTypeMap(MedicamentoEntity.class, MedicamentoDto.class).<Long>addMapping(src -> src.getLaboratorio().getId(), (dest,value) -> dest.setIdLaboratorio( value));
	
	
		//return modelMapper2();

		
		
		modelMapper2.createTypeMap(MedicamentoEntity.class, MedicamentoDto.class).addMappings(mapper -> {
			  mapper.map(src -> src.getGrupoMedicamento().getId(),   MedicamentoDto::setIdGrupoMedicamento);
			  mapper.map(src -> src.getLaboratorio().getId(),  MedicamentoDto::setIdLaboratorio); 
			});
		
		modelMapper2.validate();
		
		return modelMapper2;
		
	}


}
