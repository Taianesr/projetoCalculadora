package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="diluicao_configuracao")
public class DiluicaoConfiguracaoEntity {
   
	@EmbeddedId
	//@EqualsAndHashCode.Include
	private DiluicaoConfiguracaoEntityPK diluicaoConfPK;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String diluente;
	private String modoPreparo;
	
	
	
	public DiluicaoConfiguracaoEntity() {
		super();
	}



	public DiluicaoConfiguracaoEntity(DiluicaoConfiguracaoEntityPK diluicaoConfPK, BigDecimal quantidadeAspirada,
			BigDecimal quantidadeAdicionada, BigDecimal concentracao, String diluente, String modoPreparo) {
		super();
		this.diluicaoConfPK = diluicaoConfPK;
		this.quantidadeAspirada = quantidadeAspirada;
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.concentracao = concentracao;
		this.diluente = diluente;
		this.modoPreparo = modoPreparo;
	}

	

	public DiluicaoConfiguracaoEntityPK getDiluicaoConfPK() {
		return diluicaoConfPK;
	}



	public void setDiluicaoConfPK(DiluicaoConfiguracaoEntityPK diluicaoConfPK) {
		this.diluicaoConfPK = diluicaoConfPK;
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



	public String getModoPreparo() {
		return modoPreparo;
	}



	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}




}