package br.com.desafioCompasso.calculadora.controller.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiluicaoConfiguracaoFormPK {
	private Long idMedicamento;
	private Long idViaAdministracao;
	private int sequencia;

}
