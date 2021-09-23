package br.com.desafioCompasso.calculadora.controller.form;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViaAdministracaoForm {
	
	private String nome;
	

	public ViaAdministracaoForm(String nome) {
		super();
		this.nome = nome;
	}


	

}
