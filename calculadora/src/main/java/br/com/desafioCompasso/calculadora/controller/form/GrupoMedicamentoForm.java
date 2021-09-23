package br.com.desafioCompasso.calculadora.controller.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GrupoMedicamentoForm {
	
	private String nome;

	public GrupoMedicamentoForm(String nome) {
		super();
		this.nome = nome;
	}

	
	

}
