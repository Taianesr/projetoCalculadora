package br.com.desafioCompasso.calculadora.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.controller.dto.DiluicaoConfiguracaoDto;
import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;

@Configuration
public class ModelMapperConfig2 {
	@Bean
	public ModelMapper modelMapper2() {
		var modelMapper = new ModelMapper();
		//modelMapper.createTypeMap(DiluicaoConfiguracaoDto.class , MedicamentoDto.class).addMappings(mapper -> {
			//mapper.map(src -> src., CalculoHistoricoDto::setLst);
			
		//});

return modelMapper;


	}


}
