package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigInteger;

import br.com.desafioCompasso.calculadora.model.GrupoMedicamento;

public class GrupoMedicamentoDto {
	
	private Long id;
	private String nome;
	
	
	
	public GrupoMedicamentoDto() {
		super();
	}

	public GrupoMedicamentoDto(GrupoMedicamento grupoMed) {
		super();
		this.id=grupoMed.getId();
		this.nome= grupoMed.getNome();
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
