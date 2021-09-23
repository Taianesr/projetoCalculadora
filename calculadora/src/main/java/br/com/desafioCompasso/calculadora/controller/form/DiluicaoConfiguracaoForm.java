package br.com.desafioCompasso.calculadora.controller.form;

import java.math.BigDecimal;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiluicaoConfiguracaoForm {
	
	private Long idViaAdministracao;
	private int sequencia;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String diluente;
	private String modoPreparo;

	
	

	public DiluicaoConfiguracaoForm(Long idMedicamento, Long idViaAdministracao, int sequencia,
			BigDecimal quantidadeAspirada, BigDecimal quantidadeAdicionada, BigDecimal concentracao, String diluente,
			String modoPreparo) {
		super();
		this.idViaAdministracao = idViaAdministracao;
		this.sequencia = sequencia;
		this.quantidadeAspirada = quantidadeAspirada;
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.concentracao = concentracao;
		this.diluente = diluente;
		this.modoPreparo = modoPreparo;
	}






	
	
	
	

}
