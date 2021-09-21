package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;

public class MedicamentoDto {

	private Long id;
	private String nome;
	private Long idGrupoMedicamento;
	private Long idLaboratorio;
	private BigDecimal concentracaoInicial;
	private String embalagemApresentada;
	private String infoObservacao;
	private String infoSobra;
	private String infoTempoAdministracao;
	private BigDecimal quantidadeApresentacao;
	private String unidadeMedida;
	private List<DiluicaoConfiguracaoDto> lstDiluicao;

	public MedicamentoDto() {
		super();
	}

	
	

	public MedicamentoDto(Long id, String nome, Long idGrupoMedicamento, Long idLaboratorio,
			BigDecimal concentracaoInicial, String embalagemApresentada, String infoObservacao, String infoSobra,
			String infoTempoAdministracao, BigDecimal quantidadeApresentacao, String unidadeMedida,
			List<DiluicaoConfiguracaoDto> lstDiluicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idGrupoMedicamento = idGrupoMedicamento;
		this.idLaboratorio = idLaboratorio;
		this.concentracaoInicial = concentracaoInicial;
		this.embalagemApresentada = embalagemApresentada;
		this.infoObservacao = infoObservacao;
		this.infoSobra = infoSobra;
		this.infoTempoAdministracao = infoTempoAdministracao;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.unidadeMedida = unidadeMedida;
		this.lstDiluicao = lstDiluicao;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
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




	public String getInfoObservacao() {
		return infoObservacao;
	}




	public void setInfoObservacao(String infoObservacao) {
		this.infoObservacao = infoObservacao;
	}




	public String getInfoSobra() {
		return infoSobra;
	}




	public void setInfoSobra(String infoSobra) {
		this.infoSobra = infoSobra;
	}




	


	public String getInfoTempoAdministracao() {
		return infoTempoAdministracao;
	}




	public void setInfoTempoAdministracao(String infoTempoAdministracao) {
		this.infoTempoAdministracao = infoTempoAdministracao;
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



	
	

	public List<DiluicaoConfiguracaoDto> getLstDiluicao() {
		return lstDiluicao;
	}




	public void setLstDiluicao(List<DiluicaoConfiguracaoDto> lstDiluicao) {
		this.lstDiluicao = lstDiluicao;
	}




	public void Converte(MedicamentoEntity medicamentoEntity, List<DiluicaoConfiguracaoDto> lstDiluicaoConfDto) {
		this.id = medicamentoEntity.getId();
		this.idGrupoMedicamento = medicamentoEntity.getGrupo_medicamento().getId();
		this.idLaboratorio = medicamentoEntity.getLaboratorio().getId();
		this.nome = medicamentoEntity.getNome();
		this.concentracaoInicial = medicamentoEntity.getConcentracaoInicial();
		this.embalagemApresentada = medicamentoEntity.getEmbalagemApresentada();
		this.infoObservacao = medicamentoEntity.getInfoObservacao();
		this.infoSobra = medicamentoEntity.getInfoSobra();
		this.infoTempoAdministracao = medicamentoEntity.getInfoTempoAdministracao();
		this.quantidadeApresentacao = medicamentoEntity.getQuantidadeApresentacao();
		this.unidadeMedida = medicamentoEntity.getUnidadeMedida();
		this.lstDiluicao= lstDiluicaoConfDto;


	}

	
	
}
