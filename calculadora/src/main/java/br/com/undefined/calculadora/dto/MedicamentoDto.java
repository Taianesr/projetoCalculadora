package br.com.undefined.calculadora.dto;

import java.math.BigInteger;

import br.com.undefined.calculadora.model.Medicamento;

public class MedicamentoDto {

	private BigInteger id;
	private BigInteger grupo_medicamento_id;
	private BigInteger laboratorio_id;
	private String nome;

	public MedicamentoDto(Medicamento medicamento) {
		super();
		this.id = medicamento.getId();
		this.grupo_medicamento_id = medicamento.getGrupo_medicamento().getId();
		this.laboratorio_id = medicamento.getLaboratorio().getId();
		this.nome = medicamento.getNome();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getGrupo_medicamento_id() {
		return grupo_medicamento_id;
	}

	public void setGrupo_medicamento_id(BigInteger grupo_medicamento_id) {
		this.grupo_medicamento_id = grupo_medicamento_id;
	}

	public BigInteger getLaboratorio_id() {
		return laboratorio_id;
	}

	public void setLaboratorio_id(BigInteger laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
