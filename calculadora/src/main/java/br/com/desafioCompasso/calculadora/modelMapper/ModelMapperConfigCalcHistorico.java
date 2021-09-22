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

		var modelMapper = new ModelMapper();

		modelMapper.createTypeMap(CalculoHistoricoEntity.class, CalculoHistoricoDto.class).addMappings(mapper -> {
			mapper.map(src -> src.getMedEntity().getNome(), CalculoHistoricoDto::setNomeMedicamento);
			mapper.map(src -> src.getViaAdmEntity().getNome(), CalculoHistoricoDto::setViaAdministracao);
			mapper.map(src -> src.getMedEntity().getQuantidadeApresentacao(),
					CalculoHistoricoDto::setQuantidadeApresentada);
			mapper.map(src -> src.getResultadosJson(),
					CalculoHistoricoDto::setResultadosJson);

		});

		modelMapper.validate();

		return modelMapper;

	}

}
