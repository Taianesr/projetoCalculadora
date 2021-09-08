package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigInteger;

import br.com.desafioCompasso.calculadora.model.GrupoMedicamento;

public class GrupoMedicamentoDto {
	
	private BigInteger id;
	private String nome;
	
	
	
	public GrupoMedicamentoDto() {
		super();
	}

	public GrupoMedicamentoDto(GrupoMedicamento grupoMed) {
		super();
		this.id=grupoMed.getId();
		this.nome= grupoMed.getNome();
	}
	
	public BigInteger getId() {
		return id;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
