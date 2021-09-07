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


//@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/laboratorio")
//@Api(value="API REST DE MEDICAMENTOS")


public class LaboratorioController {

	@Autowired
	private LaboratorioService laboratorioService;

	
	@GetMapping("/listar")
	//@ApiOperation(value="Retorna uma lista de produtos")
	public List<Laboratorio> listarMedicamentos(){
		return laboratorioService.listar();
		
	}
	
	
	@PostMapping("/criar")
	//@ApiOperation(value="Retorna uma lista de produtos")
	public ResponseEntity<LaboratorioDto> criar(@RequestBody LaboratorioForm laboratorioForm, UriComponentsBuilder uriBuilder) {
	    Laboratorio lab = laboratorioService.criar(laboratorioForm);
	    
	    URI uri= uriBuilder.path("/{id}/").buildAndExpand(lab.getId()).toUri();
	    
		return ResponseEntity.created(uri).body(new LaboratorioDto(lab));
		
	}
	
	
	@PutMapping("/{id}/atualizar")
	//@ApiOperation(value="Retorna uma lista de produtos")
	public ResponseEntity<LaboratorioDto> atualizar(@PathVariable BigInteger id, @RequestBody AtualizacaoLaboratorioForm atlabForm) throws ServiceException{
		
		LaboratorioDto labDto =  laboratorioService.atualizar(id, atlabForm);
		
		return ResponseEntity.ok(labDto);
		
	}
	
	
	
	
}
