package br.com.undefined.calculadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.undefined.calculadora.controller.form.LaboratorioForm;
import br.com.undefined.calculadora.dto.LaboratorioDto;
import br.com.undefined.calculadora.model.Laboratorio;
import br.com.undefined.calculadora.service.LaboratorioService;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

	private LaboratorioService laboratorioService;
	
	@GetMapping("/listar")
	public List<Laboratorio> listarMedicamentos(){
		return laboratorioService.listar();
		
	}
	
	
	@PostMapping("/criar")
	public ResponseEntity<LaboratorioDto> criar(@RequestBody LaboratorioForm laboratorioForm ) {
		
		
		
		return null;
		
		
		
	}
	
	
	
}
