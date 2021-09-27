package br.com.desafioCompasso.calculadora.controller.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LaboratorioForm {

	private String nome;

	public LaboratorioForm(String nome) {
		super();
		this.nome = nome;
	}

}
