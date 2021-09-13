package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigInteger;


public class AtualizacaoMedicamentoForm {

	private String nome;
	private Long laboratorio_id;
	private Long grupoMedicamento_id;

	public AtualizacaoMedicamentoForm() {
		super();
	}


	//errada ordem dos parâmetros
	public AtualizacaoMedicamentoForm(String nome, Long laboratorio_id, Long grupoMedicamento_id) {
		super();
		this.nome = nome;
		this.laboratorio_id = laboratorio_id;
		this.grupoMedicamento_id = grupoMedicamento_id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getLaboratorio_id() {
		return laboratorio_id;
	}

	public void setLaboratorio_id(Long laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}


	public Long getGrupoMedicamento_id() {
		return grupoMedicamento_id;
	}


	public void setGrupoMedicamento_id(Long grupoMedicamento_id) {
		this.grupoMedicamento_id = grupoMedicamento_id;
	}

	
	
	
}
