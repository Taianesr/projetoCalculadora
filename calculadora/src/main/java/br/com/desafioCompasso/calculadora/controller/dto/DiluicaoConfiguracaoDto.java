package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiluicaoConfiguracaoDto {

	private Long idViaAdministracao;
	private Long idMedicamento;
	private int sequencia;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String diluente;
	private String modoPreparo;

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

}
