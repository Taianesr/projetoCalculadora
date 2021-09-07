package br.com.undefined.calculadora.dto;

import java.math.BigInteger;

import br.com.undefined.calculadora.model.Laboratorio;

public class LaboratorioDto {
	private BigInteger id;
	private String nome;
	
	public LaboratorioDto() {
		super();
	}

	public LaboratorioDto(Laboratorio lab) {
		this.id=lab.getId();
		this.nome= lab.getNome();
		
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
