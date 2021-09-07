package br.com.undefined.calculadora.controller.form;

public class AtualizacaoLaboratorioForm {
	private String nome;

	//nao sei se devo usar construtores
	public AtualizacaoLaboratorioForm() {
		super();
	}

	public AtualizacaoLaboratorioForm(String nome) {
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
