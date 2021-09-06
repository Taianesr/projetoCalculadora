package br.com.undefined.calculadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.undefined.calculadora.model.Laboratorio;
import br.com.undefined.calculadora.repository.LaboratorioRepository;

@Service
public class LaboratorioService {
	
	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	public List<Laboratorio> listar(){
		List<Laboratorio> lst= laboratorioRepository.findAll();
		return lst;
	}
	
	
	

}
