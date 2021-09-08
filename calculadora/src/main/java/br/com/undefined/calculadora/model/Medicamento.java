package br.com.undefined.calculadora.model;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Medicamento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@ManyToOne
	@JoinColumn(name="grupo_medicamento_id")
	private Grupo_medicamento grupoMedicamento;
	@ManyToOne
	@JoinColumn(name="laboratorio_id")
	private Laboratorio laboratorio;
	@Column
	private String nome;

	public Medicamento() {
		super();
	}

	
	public Medicamento(BigInteger id, Grupo_medicamento grupo_medicamento, Laboratorio laboratorio, String nome) {
		super();
		this.id = id;
		this.grupoMedicamento = grupo_medicamento;
		this.laboratorio = laboratorio;
		this.nome = nome;
	}
	
	
	public Medicamento(Grupo_medicamento grupo_medicamento, Laboratorio laboratorio, String nome) {
		super();
		this.grupoMedicamento = grupo_medicamento;
		this.laboratorio = laboratorio;
		this.nome = nome;
	}



	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Grupo_medicamento getGrupo_medicamento() {
		return grupoMedicamento;
	}

	public void setGrupo_medicamento(Grupo_medicamento grupo_medicamento) {
		this.grupoMedicamento = grupo_medicamento;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
}
