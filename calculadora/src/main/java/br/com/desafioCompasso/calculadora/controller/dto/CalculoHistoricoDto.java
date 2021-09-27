package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CalculoHistoricoDto {

	private Date dataCalculo;
	private Long id;
	private String nomeMedicamento;
	private BigDecimal quantidadeApresentada;
	private BigDecimal quantidadePrescrita;
	private String resultadosJson;
	private String viaAdministracao;

	public CalculoHistoricoDto(Long id, Date dataCalculo, String nomeMedicamento, BigDecimal quantidadeApresentada,
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

}
