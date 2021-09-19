package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigInteger;

import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;

public class LaboratorioDto {
	private Long id;
	private String nome;
	
	public LaboratorioDto() {
		super();
	}

	public LaboratorioDto(LaboratorioEntity lab) {
		this.id=lab.getId();
		this.nome= lab.getNome();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	

}
