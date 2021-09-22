package br.com.desafioCompasso.calculadora.controller.dto;

import java.util.List;

public class CalculoDto {
	
	private String infoAdministracao;
	private List<String> passosAdministracao;
	private List<String> infoList;
	
	
	
	public CalculoDto() {
		super();
	}



	public CalculoDto(String infoAdministracao, List<String> passosAdministracao, List<String> infoList) {
		super();
		this.infoAdministracao = infoAdministracao;
		this.passosAdministracao =  passosAdministracao;
		this.infoList = infoList;
	}



	public String getInfoAdministracao() {
		return infoAdministracao;
	}



	public void setInfoAdministracao(String infoAdministracao) {
		this.infoAdministracao = infoAdministracao;
	}



	public List<String> getPassosAdministracao() {
		return passosAdministracao;
	}



	public void setPassosAdministracao(List<String> passosAdministracao) {
		this.passosAdministracao = passosAdministracao;
	}



	public List<String> getInfoList() {
		return infoList;
	}



	public void setInfoList(List<String> infoList) {
		this.infoList = infoList;
	}
	
	
	
	
	

}
