package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigDecimal;

public class DiluicaoConfiguracaoDto {
	
	
	private Long idViaAdministracao;
	private Long idMedicamento;
	private int sequencia;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String diluente;
	private String modoPreparo;
	
	
	
	
	public DiluicaoConfiguracaoDto() {
		super();
	}




	



	public DiluicaoConfiguracaoDto(Long idViaAdministracao, Long idMedicamento, int sequencia,
			BigDecimal quantidadeAspirada, BigDecimal quantidadeAdicionada, BigDecimal concentracao, String diluente,
			String modoPreparo) {
		super();
		this.idViaAdministracao = idViaAdministracao;
		this.idMedicamento = idMedicamento;
		this.sequencia = sequencia;
		this.quantidadeAspirada = quantidadeAspirada;
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.concentracao = concentracao;
		this.diluente = diluente;
		this.modoPreparo = modoPreparo;
	}








	public int getSequencia() {
		return sequencia;
	}




	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}




	public Long getIdViaAdministracao() {
		return idViaAdministracao;
	}




	public void setIdViaAdministracao(Long idViaAdministracao) {
		this.idViaAdministracao = idViaAdministracao;
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








	public Long getIdMedicamento() {
		return idMedicamento;
	}








	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	
	
	
	
	

}
