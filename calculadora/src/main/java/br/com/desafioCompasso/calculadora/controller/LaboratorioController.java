package br.com.desafioCompasso.calculadora.controller;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafioCompasso.calculadora.controller.dto.LaboratorioDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoLaboratorioForm;
import br.com.desafioCompasso.calculadora.controller.form.LaboratorioForm;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.Laboratorio;
import br.com.desafioCompasso.calculadora.service.LaboratorioService;


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
	
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity<LaboratorioDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoLaboratorioForm atlabForm) throws ServiceException{
		
		LaboratorioDto labDto =  laboratorioService.atualizar(id, atlabForm);
		
		return ResponseEntity.ok(labDto);
		
	}
	
	
	
	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id){
		laboratorioService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
