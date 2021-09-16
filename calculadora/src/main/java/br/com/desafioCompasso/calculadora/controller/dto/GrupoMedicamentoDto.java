package br.com.desafioCompasso.calculadora.controller.dto;

import br.com.desafioCompasso.calculadora.model.GrupoMedicamentoEntity;

public class GrupoMedicamentoDto {
	
	private Long id;
	private String nome;
	
	public GrupoMedicamentoDto() {
		super();
	}

	public GrupoMedicamentoDto(GrupoMedicamentoEntity grupoMed) {
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
