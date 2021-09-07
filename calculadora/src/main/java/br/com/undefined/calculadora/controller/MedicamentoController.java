package br.com.undefined.calculadora.controller;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.undefined.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.undefined.calculadora.controller.form.MedicamentoForm;
import br.com.undefined.calculadora.dto.MedicamentoDto;
import br.com.undefined.calculadora.exceptions.ServiceException;
import br.com.undefined.calculadora.model.Medicamento;
import br.com.undefined.calculadora.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping("/listar")
	public List<Medicamento> listarMedicamentos() {
		return medicamentoService.listar();

	}
	
	@PostMapping("/criar")
	public ResponseEntity<MedicamentoDto> criar(@RequestBody MedicamentoForm medForm,
			UriComponentsBuilder uriBuilder) throws Exception {

		Medicamento med = medicamentoService.criar(medForm);

		URI uri = uriBuilder.path("/{id}/").buildAndExpand(med.getId()).toUri();

		return ResponseEntity.created(uri).body(new MedicamentoDto(med));

	}
	
	@PutMapping("/{id}/atualizar")
	public ResponseEntity<MedicamentoDto> atualizar(@PathVariable BigInteger id, @RequestBody AtualizacaoMedicamentoForm atMedForm) throws ServiceException{
		
		MedicamentoDto medDto =  medicamentoService.atualizar(id, atMedForm);
		
		return ResponseEntity.ok(medDto);
		
	}
	

	
	

}
