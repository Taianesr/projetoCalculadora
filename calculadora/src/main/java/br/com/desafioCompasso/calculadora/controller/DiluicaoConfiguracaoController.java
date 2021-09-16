package br.com.desafioCompasso.calculadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
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
	
	

}
