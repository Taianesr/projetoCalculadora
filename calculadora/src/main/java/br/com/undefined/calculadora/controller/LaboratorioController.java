package br.com.undefined.calculadora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.undefined.calculadora.model.Laboratorio;
import br.com.undefined.calculadora.service.LaboratorioService;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

	private LaboratorioService laboratorioService;
	
	@GetMapping
	public List<Laboratorio> listarMedicamentos(){
		return laboratorioService.listar();
		
	}
	
	
	
}
