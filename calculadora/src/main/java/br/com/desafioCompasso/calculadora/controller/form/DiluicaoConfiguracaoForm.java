package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigDecimal;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;

public class DiluicaoConfiguracaoForm {
	
	private int sequencia;
	private Long idMedicamento;
	private Long idViaAdministracao;
	private String modoPreparo;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String diluente;
	
	
	public DiluicaoConfiguracaoForm() {
		super();
	}
	

	
	public DiluicaoConfiguracaoForm(int sequencia, Long idMedicamento, Long idViaAdministracao, String modoPreparo,
			BigDecimal quantidadeAspirada, BigDecimal quantidadeAdicionada, BigDecimal concentracao, String diluente) {
		super();
		this.sequencia = sequencia;
		this.idMedicamento = idMedicamento;
		this.idViaAdministracao = idViaAdministracao;
		this.modoPreparo = modoPreparo;
		this.quantidadeAspirada = quantidadeAspirada;
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.concentracao = concentracao;
		this.diluente = diluente;
	}



	public int getSequencia() {
		return sequencia;
	}



	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}



	public String getModoPreparo() {
		return modoPreparo;
	}



	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}



	public BigDecimal getQuantidadeAspirada() {
		return quantidadeAspirada;
	}



	public void setQuantidadeAspirada(BigDecimal quantidadeAspirada) {
		this.quantidadeAspirada = quantidadeAspirada;
	}



	public BigDecimal getQuantidadeAdicionada() {
		return quantidadeAdicionada;
	}



	public void setQuantidadeAdicionada(BigDecimal quantidadeAdicionada) {
		this.quantidadeAdicionada = quantidadeAdicionada;
	}



	public BigDecimal getConcentracao() {
		return concentracao;
	}



	public void setConcentracao(BigDecimal concentracao) {
		this.concentracao = concentracao;
	}



	public String getDiluente() {
		return diluente;
	}



	public void setDiluente(String diluente) {
		this.diluente = diluente;
	}






	public Long getIdViaAdministracao() {
		return idViaAdministracao;
	}






	public void setIdViaAdministracao(Long idViaAdministracao) {
		this.idViaAdministracao = idViaAdministracao;
	}



	public Long getIdMedicamento() {
		return idMedicamento;
	}



	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}



	
	
	
	
	

}
