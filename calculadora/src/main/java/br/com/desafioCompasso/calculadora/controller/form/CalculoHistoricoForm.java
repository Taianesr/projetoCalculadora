package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CalculoHistoricoForm {

	private Long idMedicamento;
	private Long idViaAdministracao;
	private String nomeUsuario;
	private BigDecimal quantidadePrescrita;
	

	public CalculoHistoricoForm(Long idMedicamento, Long idViaAdministracao, String nomeUsuario,
			BigDecimal quantidadePrescrita) {
		super();
		this.idMedicamento = idMedicamento;
		this.idViaAdministracao = idViaAdministracao;
		this.nomeUsuario = nomeUsuario;
		this.quantidadePrescrita = quantidadePrescrita;
	}


	
}
