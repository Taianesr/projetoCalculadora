package br.com.desafioCompasso.calculadora.controller;

import java.net.URI;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoDto;
import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.controller.form.CalculoHistoricoForm;
import br.com.desafioCompasso.calculadora.service.CalculoHistoricoService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/calculo_historico")
public class CalculoHistoricoController {

	@Autowired
	private CalculoHistoricoService calculoHistoricoService;

	@GetMapping()
	public List<CalculoHistoricoDto> listarLaboratorioId(@RequestParam(required = false) Long id, 
			@RequestParam(required = false) Date dataInicial, @RequestParam(required = false) Date dataFinal) {
		return calculoHistoricoService.listar(id, dataInicial, dataFinal);

	}

	@PostMapping("/criar")
	public ResponseEntity<CalculoDto> criar(@RequestBody CalculoHistoricoForm calculoHistoricoForm,
			UriComponentsBuilder uriBuilder) {

		CalculoDto calcHistDto = calculoHistoricoService.criar(calculoHistoricoForm);

		URI uri = uriBuilder.path("/{id}/").buildAndExpand(calcHistDto).toUri();

		return ResponseEntity.created(uri).body(calcHistDto);

	}

}
