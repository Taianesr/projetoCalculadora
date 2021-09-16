package br.com.desafioCompasso.calculadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfig;
import br.com.desafioCompasso.calculadora.repository.DiluicaoConfiguracaoRepository;

@Service
public class DiluicaoConfiguracaoService {
	
	@Autowired
	private DiluicaoConfiguracaoRepository diluicaoConfRepository;
	
	@Autowired
	private ModelMapperConfig modelMapper;

	public List<DiluicaoConfiguracaoEntity> listar() {
		return diluicaoConfRepository.findAll();
	}
	
	
	
	

}
