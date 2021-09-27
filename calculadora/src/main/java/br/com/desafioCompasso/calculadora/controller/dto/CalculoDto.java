package br.com.desafioCompasso.calculadora.controller.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CalculoDto {

	private String infoAdministracao;
	private List<String> passosAdministracao = new ArrayList<String>();
	private List<String> infoList = new ArrayList<String>();

	public CalculoDto(String infoAdministracao, List<String> passosAdministracao, List<String> infoList) {
		super();
		this.infoAdministracao = infoAdministracao;
		this.passosAdministracao = passosAdministracao;
		this.infoList = infoList;
	}

}
