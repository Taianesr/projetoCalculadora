package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@Table(name = "diluicao_configuracao")
public class DiluicaoConfiguracaoEntity {
   
	@EmbeddedId
	@EqualsAndHashCode.Include
	private DiluicaoConfiguracaoEntityPK diluicaoConfPK;
	@Column(name = "medicamento_id", nullable = false, insertable = false, updatable = false)
    private Long medicamentoId;
    @Column(name = "via_administracao_id", nullable = false, insertable = false, updatable = false)
    private Long viaAdministracaoId;
    @Column(name="sequencia", nullable = false, insertable = false, updatable = false)  
    private int sequencia;
	@Column(name ="quantidade_aspirada")
	private BigDecimal quantidadeAspirada;
	@Column(name ="quantidade_adicionada")
	private BigDecimal quantidadeAdicionada;
	@Column(name ="concentracao")
	private BigDecimal concentracao;
	@Column(name ="diluente")
	private String diluente;
	@Column(name ="modo_preparo")
	private String modoPreparo;
	


	public DiluicaoConfiguracaoEntity(DiluicaoConfiguracaoEntityPK diluicaoConfPK, BigDecimal quantidadeAspirada,
			BigDecimal quantidadeAdicionada, BigDecimal concentracao, String diluente, String modoPreparo) {
		super();
		this.diluicaoConfPK = diluicaoConfPK;
		this.quantidadeAspirada = quantidadeAspirada;
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.concentracao = concentracao;
		this.diluente = diluente;
		this.modoPreparo = modoPreparo;
	}
	
	
	

	public DiluicaoConfiguracaoEntity(BigDecimal quantidadeAspirada,
			BigDecimal quantidadeAdicionada, BigDecimal concentracao, String diluente, String modoPreparo) {
		super();
		this.quantidadeAspirada = quantidadeAspirada;
		this.quantidadeAdicionada = quantidadeAdicionada;
		this.concentracao = concentracao;
		this.diluente = diluente;
		this.modoPreparo = modoPreparo;
	}




	public DiluicaoConfiguracaoEntity(Long medicamentoId, Long viaAdministracaoId, int sequencia) {
		super();
		this.medicamentoId = medicamentoId;
		this.viaAdministracaoId = viaAdministracaoId;
		this.sequencia = sequencia;
	}

	





	



	


}
