package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigDecimal;
import java.util.List;

public class MedicamentoForm {
	
	private String nome;
	private BigDecimal concentracaoInicial;
	private String embalagemApresentada;
	private Long idGrupoMedicamento;
	private Long idLaboratorio;
	private String infoObs;
	private String infoSobra;
	private String infoTempoAdm;
	private BigDecimal quantidadeApresentacao;
	private String unidadeMedida;

	
	private List<DiluicaoConfiguracaoForm> diluicaoConfiguracaoForm; 
	
	public MedicamentoForm() {
		super();
	}
	
	


	public MedicamentoForm(String nome, BigDecimal concentracaoInicial, String embalagemApresentada,
			Long idGrupoMedicamento, Long idLaboratorio, String infoObs, String infoSobra, String infoTempoAdm,
			BigDecimal quantidadeApresentacao, String unidadeMedida,
			List<DiluicaoConfiguracaoForm> diluicaoConfiguracaoForm) {
		super();
		this.nome = nome;
		this.concentracaoInicial = concentracaoInicial;
		this.embalagemApresentada = embalagemApresentada;
		this.idGrupoMedicamento = idGrupoMedicamento;
		this.idLaboratorio = idLaboratorio;
		this.infoObs = infoObs;
		this.infoSobra = infoSobra;
		this.infoTempoAdm = infoTempoAdm;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.unidadeMedida = unidadeMedida;
		this.diluicaoConfiguracaoForm = diluicaoConfiguracaoForm;
	}




	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getConcentracaoInicial() {
		return concentracaoInicial;
	}

	public void setConcentracaoInicial(BigDecimal concentracaoInicial) {
		this.concentracaoInicial = concentracaoInicial;
	}

	public String getEmbalagemApresentada() {
		return embalagemApresentada;
	}

	public void setEmbalagemApresentada(String embalagemApresentada) {
		this.embalagemApresentada = embalagemApresentada;
	}

	public Long getIdGrupoMedicamento() {
		return idGrupoMedicamento;
	}

	public void setIdGrupoMedicamento(Long idGrupoMedicamento) {
		this.idGrupoMedicamento = idGrupoMedicamento;
	}

	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public String getInfoObs() {
		return infoObs;
	}

	public void setInfoObs(String infoObs) {
		this.infoObs = infoObs;
	}

	public String getInfoSobra() {
		return infoSobra;
	}

	public void setInfoSobra(String infoSobra) {
		this.infoSobra = infoSobra;
	}

	public String getInfoTempoAdm() {
		return infoTempoAdm;
	}

	public void setInfoTempoAdm(String infoTempoAdm) {
		this.infoTempoAdm = infoTempoAdm;
	}

	public BigDecimal getQuantidadeApresentacao() {
		return quantidadeApresentacao;
	}

	public void setQuantidadeApresentacao(BigDecimal quantidadeApresentacao) {
		this.quantidadeApresentacao = quantidadeApresentacao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public List<DiluicaoConfiguracaoForm> getDiluicaoConfiguracaoForm() {
		return diluicaoConfiguracaoForm;
	}

	public void setDiluicaoConfiguracaoForm(List<DiluicaoConfiguracaoForm> diluicaoConfiguracaoForm) {
		this.diluicaoConfiguracaoForm = diluicaoConfiguracaoForm;
	}
	
	
	

}
