package br.com.desafioCompasso.calculadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@Table(name = "via_administracao")
public class ViaAdministracaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;

	public ViaAdministracaoEntity(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

}
