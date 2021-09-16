package br.com.desafioCompasso.calculadora.controller.dto;

public class ViaAdministracaoDto {
	
	private Long id;
	private String nome;
	
	public ViaAdministracaoDto() {
		super();
	}
	
	//nao passei a viaAdm por parametro
	public ViaAdministracaoDto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
