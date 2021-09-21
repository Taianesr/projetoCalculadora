package br.com.desafioCompasso.calculadora.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigGrupoMed {


	@Bean
	public ModelMapper modelMapperGrupoMed() {
	return new ModelMapper();
	
	
}
	
}
