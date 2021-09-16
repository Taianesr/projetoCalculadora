package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="diluicao_configuracao")
public class DiluicaoConfiguracaoEntity {
   
	@ManyToOne
	@JoinColumn(name = "medicamento_id", referencedColumnName = "id" )
	private MedicamentoEntity medicamento;
	@ManyToOne
	@JoinColumn(name = "via_administracao_id", referencedColumnName = "id" )
	private ViaAdministracaoEntity viaAdministracao;
	private int sequencia;
	private BigDecimal quantidadeAspirada;
	private BigDecimal quantidadeAdicionada;
	private BigDecimal concentracao;
	private String diluente;
	private String modoPreparo;


    



}
