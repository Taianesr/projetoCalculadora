package br.com.desafioCompasso.calculadora.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="medicamento")

public class MedicamentoEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "grupo_medicamento_id", referencedColumnName = "id" )
	private GrupoMedicamentoEntity grupoMedicamento;
	@ManyToOne
	@JoinColumn(name = "laboratorio_id", referencedColumnName = "id")
	private LaboratorioEntity laboratorio;
	private String nome;

	public MedicamentoEntity() {
		super();
	}

	
	public MedicamentoEntity(Long id, GrupoMedicamentoEntity grupo_medicamento, LaboratorioEntity laboratorio, String nome) {
		super();
		this.id = id;
		this.grupoMedicamento = grupo_medicamento;
		this.laboratorio = laboratorio;
		this.nome = nome;
	}
	
	
	public MedicamentoEntity(GrupoMedicamentoEntity grupo_medicamento, LaboratorioEntity laboratorio, String nome) {
		super();
		this.grupoMedicamento = grupo_medicamento;
		this.laboratorio = laboratorio;
		this.nome = nome;
	}


	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public GrupoMedicamentoEntity getGrupoMedicamento() {
		return grupoMedicamento;
	}


	public void setGrupoMedicamento(GrupoMedicamentoEntity grupoMedicamento) {
		this.grupoMedicamento = grupoMedicamento;
	}


	public GrupoMedicamentoEntity getGrupo_medicamento() {
		return grupoMedicamento;
	}

	public void setGrupo_medicamento(GrupoMedicamentoEntity grupo_medicamento) {
		this.grupoMedicamento = grupo_medicamento;
	}

	public LaboratorioEntity getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(LaboratorioEntity laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
}
