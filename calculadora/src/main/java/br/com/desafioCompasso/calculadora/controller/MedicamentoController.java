package br.com.desafioCompasso.calculadora.controller;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.MedicamentoForm;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import br.com.desafioCompasso.calculadora.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping("/listar")
	public List<MedicamentoEntity> listarMedicamentos() {
		return medicamentoService.listar();

	}
	
	@GetMapping("/listar/{id}")
	public MedicamentoDto listarMedicamentoId(Long id) {
		return medicamentoService.listarId(id);

	}
	
	@GetMapping("/listar/{nome}")
	public MedicamentoDto listarMedicamentoNome(String nome){
		return medicamentoService.listarNome(nome);
		
	}
	
	@PostMapping("/criar")
	public ResponseEntity<MedicamentoDto> criar(@RequestBody MedicamentoForm medForm,
			UriComponentsBuilder uriBuilder) throws Exception {

		MedicamentoDto medDto = medicamentoService.criar(medForm);

		URI uri = uriBuilder.path("/{id}/").buildAndExpand(medDto.getId()).toUri();

		return ResponseEntity.created(uri).body(medDto);

	}
	
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity<MedicamentoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoMedicamentoForm atMedForm) throws ServiceException{
		
		MedicamentoDto medDto =  medicamentoService.atualizar(id, atMedForm);
		
		return ResponseEntity.ok(medDto);
		
	}
	
	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id){
		medicamentoService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	

}
