package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class CalculoHistoricoDto {
	
	private Date dataCalculo;
	private Long id;
	private String nomeMedicamento;
	private BigDecimal quantidadeApresentada;
	private BigDecimal quantidadePrescrita;
	private String resultadosJson;
	private String viaAdministracao;
	
	
	public CalculoHistoricoDto() {
		super();
	}

	public CalculoHistoricoDto( Long id,Date dataCalculo, String nomeMedicamento, BigDecimal quantidadeApresentada,
			BigDecimal quantidadePrescrita, String resultadosJson, String viaAdministracao) {
		super();
		this.dataCalculo = dataCalculo;
		this.id = id;
		this.nomeMedicamento = nomeMedicamento;
		this.quantidadeApresentada = quantidadeApresentada;
		this.quantidadePrescrita = quantidadePrescrita;
		this.resultadosJson = resultadosJson;
		this.viaAdministracao = viaAdministracao;
	}




	public Date getDataCalculo() {
		return dataCalculo;
	}




	public void setDataCalculo(Date dataCalculo) {
		this.dataCalculo = dataCalculo;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNomeMedicamento() {
		return nomeMedicamento;
	}




	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}




	public BigDecimal getQuantidadeApresentada() {
		return quantidadeApresentada;
	}




	public void setQuantidadeApresentada(BigDecimal quantidadeApresentada) {
		this.quantidadeApresentada = quantidadeApresentada;
	}




	public BigDecimal getQuantidadePrescrita() {
		return quantidadePrescrita;
	}




	public void setQuantidadePrescrita(BigDecimal quantidadePrescrita) {
		this.quantidadePrescrita = quantidadePrescrita;
	}




	public String getResultadosJson() {
		return resultadosJson;
	}




	public void setResultadosJson(String resultadosJson) {
		this.resultadosJson = resultadosJson;
	}




	public String getViaAdministracao() {
		return viaAdministracao;
	}




	public void setViaAdministracao(String viaAdministracao) {
		this.viaAdministracao = viaAdministracao;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
