package br.com.desafioCompasso.calculadora.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigLaboratorio {
	
	@Bean
	public ModelMapper modelMapperLab() {
	return new ModelMapper();
	}

	
		
}
