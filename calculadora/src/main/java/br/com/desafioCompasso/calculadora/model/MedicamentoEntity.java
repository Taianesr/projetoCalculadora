package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="medicamento")

public class MedicamentoEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "grupo_medicamento_id", referencedColumnName = "id" )
	private GrupoMedicamentoEntity grupoMedicamento;
	@ManyToOne
	@JoinColumn(name = "laboratorio_id", referencedColumnName = "id")
	private LaboratorioEntity laboratorio;
	@Column(name ="nome")
	private String nome;
	
	@Column(name ="concentracao_inicial")
	private BigDecimal concentracaoInicial;
	
	@Column(name ="embalagem_apresentada")
	private String embalagemApresentada;
	
	@Column(name ="quantidade_apresentacao")
	private BigDecimal quantidadeApresentacao;
	
	@Column(name ="unidade_medida")
	private String unidadeMedida;
	
	@Column(name ="info_observacao")
	private String infoObservacao;
	
	@Column(name="info_sobra")
	private String infoSobra;
	
	
	private String infoTempoAdministracao;
	

	public MedicamentoEntity() {
		super();
	}
	

	public MedicamentoEntity(Long id, GrupoMedicamentoEntity grupoMedicamento, LaboratorioEntity laboratorio,
			String nome, BigDecimal concentracaoInicial, String embalagemApresentada, BigDecimal quantidadeApresentacao,
			String unidadeMedida, String infoObservacao, String infoSobra, String infoTempoAdministracao) {
		super();
		this.id = id;
		this.grupoMedicamento = grupoMedicamento;
		this.laboratorio = laboratorio;
		this.nome = nome;
		this.concentracaoInicial = concentracaoInicial;
		this.embalagemApresentada = embalagemApresentada;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.unidadeMedida = unidadeMedida;
		this.infoObservacao = infoObservacao;
		this.infoSobra = infoSobra;
		this.infoTempoAdministracao = infoTempoAdministracao;
	}
	

	public MedicamentoEntity( GrupoMedicamentoEntity grupoMedicamento, LaboratorioEntity laboratorio,
			String nome, BigDecimal concentracaoInicial, String embalagemApresentada, BigDecimal quantidadeApresentacao,
			String unidadeMedida, String infoObservacao, String infoSobra, String infoTempoAdministracao) {
		super();
		this.grupoMedicamento = grupoMedicamento;
		this.laboratorio = laboratorio;
		this.nome = nome;
		this.concentracaoInicial = concentracaoInicial;
		this.embalagemApresentada = embalagemApresentada;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.unidadeMedida = unidadeMedida;
		this.infoObservacao = infoObservacao;
		this.infoSobra = infoSobra;
		this.infoTempoAdministracao = infoTempoAdministracao;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public GrupoMedicamentoEntity getGrupoMedicamento() {
		return grupoMedicamento;
	}


	public void setGrupoMedicamento(GrupoMedicamentoEntity grupoMedicamento) {
		this.grupoMedicamento = grupoMedicamento;
	}


	public GrupoMedicamentoEntity getGrupo_medicamento() {
		return grupoMedicamento;
	}

	public void setGrupo_medicamento(GrupoMedicamentoEntity grupo_medicamento) {
		this.grupoMedicamento = grupo_medicamento;
	}

	public LaboratorioEntity getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(LaboratorioEntity laboratorio) {
		this.laboratorio = laboratorio;
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
	
	


	
	
}
