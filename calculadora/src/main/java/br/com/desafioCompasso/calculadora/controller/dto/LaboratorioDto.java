package br.com.desafioCompasso.calculadora.controller.dto;


import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LaboratorioDto {
	private Long id;
	private String nome;
	

	public LaboratorioDto(LaboratorioEntity lab) {
		this.id=lab.getId();
		this.nome= lab.getNome();
		
	}


	

}
