package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizacaoMedicamentoForm {

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

	public AtualizacaoMedicamentoForm(String nome, BigDecimal concentracaoInicial, String embalagemApresentada,
			Long idGrupoMedicamento, Long idLaboratorio, String infoObs, String infoSobra, String infoTempoAdm,
			BigDecimal quantidadeApresentacao, String unidadeMedida) {
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
	}

}
