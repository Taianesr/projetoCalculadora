package br.com.desafioCompasso.calculadora.controller.dto;

import br.com.desafioCompasso.calculadora.model.GrupoMedicamentoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GrupoMedicamentoDto {

	private Long id;
	private String nome;

	public GrupoMedicamentoDto(GrupoMedicamentoEntity grupoMed) {
		super();
		this.id = grupoMed.getId();
		this.nome = grupoMed.getNome();
	}

}
