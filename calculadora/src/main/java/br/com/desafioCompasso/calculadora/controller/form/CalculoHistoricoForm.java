package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigDecimal;

public class CalculoHistoricoForm {

	private Long idMedicamento;
	private Long idViaAdministracao;
	private String nomeUsuario;
	private BigDecimal quantidadePrescrita;
	
	public CalculoHistoricoForm() {
		super();
	}

	public CalculoHistoricoForm(Long idMedicamento, Long idViaAdministracao, String nomeUsuario,
			BigDecimal quantidadePrescrita) {
		super();
		this.idMedicamento = idMedicamento;
		this.idViaAdministracao = idViaAdministracao;
		this.nomeUsuario = nomeUsuario;
		this.quantidadePrescrita = quantidadePrescrita;
	}

	public Long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public Long getIdViaAdministracao() {
		return idViaAdministracao;
	}

	public void setIdViaAdministracao(Long idViaAdministracao) {
		this.idViaAdministracao = idViaAdministracao;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public BigDecimal getQuantidadePrescrita() {
		return quantidadePrescrita;
	}

	public void setQuantidadePrescrita(BigDecimal quantidadePrescrita) {
		this.quantidadePrescrita = quantidadePrescrita;
	}
	
	
	
	
	
	
	
}
