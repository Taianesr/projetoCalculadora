package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigInteger;


public class AtualizacaoMedicamentoForm {

	private String nome;
	private BigInteger laboratorio_id;

	public AtualizacaoMedicamentoForm() {
		super();
	}

	public AtualizacaoMedicamentoForm(String nome, BigInteger laboratorio_id) {
		super();
		this.nome = nome;
		this.laboratorio_id = laboratorio_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigInteger getLaboratorio_id() {
		return laboratorio_id;
	}

	public void setLaboratorio_id(BigInteger laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}

}
