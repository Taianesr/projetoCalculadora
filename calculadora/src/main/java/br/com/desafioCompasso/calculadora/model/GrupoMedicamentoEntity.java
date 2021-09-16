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
public class GrupoMedicamentoEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	public GrupoMedicamentoEntity() {
		super();
	}
	

	public GrupoMedicamentoEntity(Long id, String nome) {
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
