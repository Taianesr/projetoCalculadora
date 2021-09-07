package br.com.undefined.calculadora.controller.form;

import java.math.BigInteger;

public class MedicamentoForm {
	
	private BigInteger grupo_medicamento_id;
	private BigInteger laboratorio_id;
	private String nome;
	
	public MedicamentoForm() {
		super();
	}
	

	public MedicamentoForm(BigInteger grupo_medicamento_id, BigInteger laboratorio_id, String nome) {
		super();
		this.grupo_medicamento_id = grupo_medicamento_id;
		this.laboratorio_id = laboratorio_id;
		this.nome = nome;
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
