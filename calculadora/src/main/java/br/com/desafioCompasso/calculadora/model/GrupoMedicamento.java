package br.com.desafioCompasso.calculadora.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="grupo_medicamento")
public class GrupoMedicamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	@Column
	private String nome;

	public GrupoMedicamento() {
		super();
	}

	public GrupoMedicamento(BigInteger id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
}