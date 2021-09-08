package br.com.desafioCompasso.calculadora.controller.form;

public class LaboratorioForm {

	private String nome;

	public LaboratorioForm() {
		super();

	}
	
	public LaboratorioForm(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
