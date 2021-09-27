package br.com.desafioCompasso.calculadora.controller.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizacaoViaAdministracaoForm {
	private String nome;

	public AtualizacaoViaAdministracaoForm(String nome) {
		super();
		this.nome = nome;
	}

}
