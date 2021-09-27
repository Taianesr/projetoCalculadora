package br.com.desafioCompasso.calculadora.controller.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizacaoGrupoMedicamentoForm {

	private String nome;

	public AtualizacaoGrupoMedicamentoForm(String nome) {
		super();
		this.nome = nome;
	}

}
