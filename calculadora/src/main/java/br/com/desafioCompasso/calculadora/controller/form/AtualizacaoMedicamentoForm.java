package br.com.desafioCompasso.calculadora.controller.form;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizacaoMedicamentoForm {

	private String nome;
	private Long laboratorio_id;
	private Long grupoMedicamento_id;


	//errada ordem dos parâmetros
	public AtualizacaoMedicamentoForm(String nome, Long laboratorio_id, Long grupoMedicamento_id) {
		super();
		this.nome = nome;
		this.laboratorio_id = laboratorio_id;
		this.grupoMedicamento_id = grupoMedicamento_id;
	}


	
}
