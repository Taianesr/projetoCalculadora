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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@Table(name = "medicamento")

public class MedicamentoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "grupo_medicamento_id", referencedColumnName = "id")
	private GrupoMedicamentoEntity grupoMedicamento;
	@ManyToOne
	@JoinColumn(name = "laboratorio_id", referencedColumnName = "id")
	private LaboratorioEntity laboratorio;

	@Column(name = "nome")
	private String nome;

	@Column(name = "concentracao_inicial")
	private BigDecimal concentracaoInicial;

	@Column(name = "embalagem_apresentada")
	private String embalagemApresentada;

	@Column(name = "quantidade_apresentacao")
	private BigDecimal quantidadeApresentacao;

	@Column(name = "unidade_medida")
	private String unidadeMedida;

	@Column(name = "info_observacao")
	private String infoObservacao;

	@Column(name = "info_sobra")
	private String infoSobra;

	@Column(name = "info_tempo_administracao")
	private String infoTempoAdministracao;

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

	public MedicamentoEntity(GrupoMedicamentoEntity grupoMedicamento, LaboratorioEntity laboratorio, String nome,
			BigDecimal concentracaoInicial, String embalagemApresentada, BigDecimal quantidadeApresentacao,
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

}
