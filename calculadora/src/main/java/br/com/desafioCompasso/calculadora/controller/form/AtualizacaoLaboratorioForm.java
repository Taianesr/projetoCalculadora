package br.com.desafioCompasso.calculadora.controller.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizacaoLaboratorioForm {
	private String nome;

	public AtualizacaoLaboratorioForm(String nome) {
		super();
		this.nome = nome;
	}

}
