package br.com.desafioCompasso.calculadora.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioCompasso.calculadora.controller.dto.DiluicaoConfiguracaoDto;
import br.com.desafioCompasso.calculadora.service.DiluicaoConfiguracaoService;

@RestController
@RequestMapping("/diluicao_configuracao")
public class DiluicaoConfiguracaoController {

	@Autowired
	private DiluicaoConfiguracaoService diluicaoConfService;

	@GetMapping("/listar")
	public List<DiluicaoConfiguracaoDto> listarGrupoMedicamentos() {
		return diluicaoConfService.listar();

	}

	@DeleteMapping("/remover/{idMedicamento}/{idViaAdministracao}/{sequencia}")
	@Transactional
	public ResponseEntity<?> excluir(Long idMedicamento, Long idViaAdministracao, int sequencia) {
		diluicaoConfService.excluir(idMedicamento, idViaAdministracao, sequencia);
		return ResponseEntity.ok().build();
	}

}
