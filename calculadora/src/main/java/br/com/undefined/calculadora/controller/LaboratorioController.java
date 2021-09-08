package br.com.undefined.calculadora.controller;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.undefined.calculadora.controller.form.AtualizacaoLaboratorioForm;
import br.com.undefined.calculadora.controller.form.LaboratorioForm;
import br.com.undefined.calculadora.dto.LaboratorioDto;
import br.com.undefined.calculadora.exceptions.ServiceException;
import br.com.undefined.calculadora.model.Laboratorio;
import br.com.undefined.calculadora.service.LaboratorioService;


@RestController
@RequestMapping(value = "/laboratorio")

public class LaboratorioController {

	@Autowired
	private LaboratorioService laboratorioService;

	
	@GetMapping("/listar")
	public List<Laboratorio> listarMedicamentos(){
		return laboratorioService.listar();
		
	}
	
	
	@PostMapping("/criar")
	public ResponseEntity<LaboratorioDto> criar(@RequestBody LaboratorioForm laboratorioForm, UriComponentsBuilder uriBuilder) {
		
	    LaboratorioDto labDto = laboratorioService.criar(laboratorioForm);
	    
	    URI uri= uriBuilder.path("/{id}/").buildAndExpand(labDto.getId()).toUri();
	    
		return ResponseEntity.created(uri).body(labDto);
		
	}
	
	
	@PutMapping("/{id}/atualizar")
	public ResponseEntity<LaboratorioDto> atualizar(@PathVariable BigInteger id, @RequestBody AtualizacaoLaboratorioForm atlabForm) throws ServiceException{
		
		LaboratorioDto labDto =  laboratorioService.atualizar(id, atlabForm);
		
		return ResponseEntity.ok(labDto);
		
	}
	
	
	
	
}
