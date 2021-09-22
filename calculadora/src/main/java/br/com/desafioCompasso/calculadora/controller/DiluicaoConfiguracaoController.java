package br.com.desafioCompasso.calculadora.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;
import br.com.desafioCompasso.calculadora.service.DiluicaoConfiguracaoService;

@RestController
@RequestMapping("/diluicao_configuracao")
public class DiluicaoConfiguracaoController {
	

	@Autowired
	private DiluicaoConfiguracaoService diluicaoConfService;
	

	
	@GetMapping("/listar")
	public List<DiluicaoConfiguracaoEntity> listarGrupoMedicamentos() {
		return diluicaoConfService.listar();

	}
	
	
	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable DiluicaoConfiguracaoEntityPK id){
		diluicaoConfService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	

}
