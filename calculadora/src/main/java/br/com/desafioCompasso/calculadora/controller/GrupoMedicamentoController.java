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

import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoGrupoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.GrupoMedicamentoForm;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.Grupo_medicamento;
import br.com.desafioCompasso.calculadora.service.GrupoMedicamentoService;
import br.com.desafioCompasso.controller.dto.GrupoMedicamentoDto;

@RestController
@RequestMapping("/grupo_medicamento")
public class GrupoMedicamentoController {

	@Autowired
	private GrupoMedicamentoService grupoMedicamentoService;
	

	@GetMapping("/listar")
	public List<Grupo_medicamento> listarGrupoMedicamentos() {
		return grupoMedicamentoService.listar();

	}

	@PostMapping("/criar")
	public ResponseEntity<GrupoMedicamentoDto> criar(@RequestBody GrupoMedicamentoForm grupoMedForm,
			UriComponentsBuilder uriBuilder) {

		GrupoMedicamentoDto grupoMedDto = grupoMedicamentoService.criar(grupoMedForm);

		URI uri = uriBuilder.path("/{id}/").buildAndExpand(grupoMedDto.getId()).toUri();

		return ResponseEntity.created(uri).body(grupoMedDto);

	}
	

	@PutMapping("/{id}/atualizar")
	@Transactional
	public ResponseEntity<GrupoMedicamentoDto> atualizar(@PathVariable BigInteger id,
			@RequestBody AtualizacaoGrupoMedicamentoForm atGrupoMedForm) throws ServiceException {

		GrupoMedicamentoDto grupoMedDto = grupoMedicamentoService.atualizar(id, atGrupoMedForm);

		return ResponseEntity.ok(grupoMedDto);

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable BigInteger id){
		grupoMedicamentoService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	

}
