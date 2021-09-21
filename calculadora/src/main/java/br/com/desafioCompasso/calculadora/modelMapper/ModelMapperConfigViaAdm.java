package br.com.desafioCompasso.calculadora.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigViaAdm {
	
	@Bean
	public ModelMapper modelMapperViaAdm() {
	return new ModelMapper();
	}
	

}
