package br.com.desafioCompasso.calculadora.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;


@Configuration
public class ModelMapperConfigCalcHistorico {

		@Bean
		public ModelMapper modelMapperCalcHistorico() {
			
			
			var modelMapper3= new ModelMapper();
			
			
			modelMapper3.createTypeMap(CalculoHistoricoEntity.class, CalculoHistoricoDto.class).addMappings(mapper -> {
				  mapper.map(src -> src.getMedEntity().getNome(),   CalculoHistoricoDto::setNomeMedicamento);
				  mapper.map(src -> src.getViaAdmEntity().getNome(),   CalculoHistoricoDto::setViaAdministracao);
				 mapper.map(src -> src.getQuantidadePrescrita(),   CalculoHistoricoDto::setQuantidadePrescrita);
				  
				});
			
			modelMapper3.validate();
			
			return modelMapper3;
			
		}
		
	
		


	

}






