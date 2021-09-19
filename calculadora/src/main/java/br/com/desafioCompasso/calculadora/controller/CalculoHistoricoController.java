package br.com.desafioCompasso.calculadora.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;
import br.com.desafioCompasso.calculadora.service.CalculoHistoricoService;


@RestController
@RequestMapping("/calculo_historico")
public class CalculoHistoricoController {
	
	@Autowired
	private CalculoHistoricoService calculoHistoricoService;
	
	@GetMapping("/listar/{id}/{dataInicial}/{dataFinal}")
	public CalculoHistoricoDto listarLaboratorioId(Long id, Date dataInicial, Date dataFinal){
		return calculoHistoricoService.listar(id, dataInicial, dataFinal);
		
	}
	
	
	
	
	
	

}
