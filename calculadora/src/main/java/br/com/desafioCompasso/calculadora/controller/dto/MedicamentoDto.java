package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigInteger;

import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;

public class MedicamentoDto {

	private Long id;
	private Long grupo_medicamento_id;
	private Long laboratorio_id;
	private String nome;
	
	public MedicamentoDto() {
		super();
	}

	public MedicamentoDto(MedicamentoEntity medicamento) {
		super();
		this.id = medicamento.getId();
		this.grupo_medicamento_id = medicamento.getGrupo_medicamento().getId();
		this.laboratorio_id = medicamento.getLaboratorio().getId();
		this.nome = medicamento.getNome();
	}	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrupo_medicamento_id() {
		return grupo_medicamento_id;
	}

	public void setGrupo_medicamento_id(Long grupo_medicamento_id) {
		this.grupo_medicamento_id = grupo_medicamento_id;
	}

	public Long getLaboratorio_id() {
		return laboratorio_id;
	}

	public void setLaboratorio_id(Long laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
