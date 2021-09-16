package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;

public class DiluicaoConfiguracaoEntity {

	private Long medicamentoId;
	private Long viaAdministracaoId;
	private int sequencia;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String diluente;
	private String modoPreparo;

	public DiluicaoConfiguracaoEntity() {
		super();
	}

	public DiluicaoConfiguracaoEntity(Long medicamentoId, Long viaAdministracaoId, int sequencia,
			BigDecimal quantidadeAspirada, BigDecimal quantidadeAdicionada, BigDecimal concentracao, String diluente,
			String modoPreparo) {
		super();
		this.medicamentoId = medicamentoId;
		this.viaAdministracaoId = viaAdministracaoId;
		this.sequencia = sequencia;
		this.quantidadeAspirada = quantidadeAspirada;
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.concentracao = concentracao;
		this.diluente = diluente;
		this.modoPreparo = modoPreparo;
	}

	public Long getMedicamentoId() {
		return medicamentoId;
	}

	public void setMedicamentoId(Long medicamentoId) {
		this.medicamentoId = medicamentoId;
	}

	public Long getViaAdministracaoId() {
		return viaAdministracaoId;
	}

	public void setViaAdministracaoId(Long viaAdministracaoId) {
		this.viaAdministracaoId = viaAdministracaoId;
	}

	public int getSequencia() {
		return sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
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
