package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@Table(name = "calculo_historico")
public class CalculoHistoricoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCalculo;

	@Column(name = "nome_usuario")
	private String nomeUsuario;

	@ManyToOne
	@JoinColumn(name = "medicamento_id", referencedColumnName = "id")
	private MedicamentoEntity medEntity;

	@OneToOne
	@JoinColumn(name = "via_administracao_id")
	private ViaAdministracaoEntity viaAdmEntity;

	@Column(name = "quantidade_prescrita")
	private BigDecimal quantidadePrescrita;

	@Column(name = "quantidade_apresentada")
	private BigDecimal quantidadeApresentada;

	@Column(name = "resultados_json")
	private String resultadosJson;

	public CalculoHistoricoEntity(Long id, Date dataCalculo, String nomeUsuario, MedicamentoEntity medEntity,
			ViaAdministracaoEntity viaAdmEntity, BigDecimal quantidadePrescrita, BigDecimal quantidadeApresentada,
			String resultadosJson) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.dataCalculo = dataCalculo;
		this.medEntity = medEntity;
		this.viaAdmEntity = viaAdmEntity;
		this.quantidadePrescrita = quantidadePrescrita;
		this.quantidadeApresentada = quantidadeApresentada;
		this.resultadosJson = resultadosJson;
	}

	public CalculoHistoricoEntity(Long id, Date dataCalculo, String nomeUsuario, MedicamentoEntity medEntity,
			ViaAdministracaoEntity viaAdmEntity) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.dataCalculo = dataCalculo;
		this.medEntity = medEntity;
		this.viaAdmEntity = viaAdmEntity;

	}

	public CalculoHistoricoEntity(String nomeUsuario, MedicamentoEntity medEntity, ViaAdministracaoEntity viaAdmEntity,
			BigDecimal quantidadePrescrita) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.medEntity = medEntity;
		this.viaAdmEntity = viaAdmEntity;
		this.quantidadePrescrita = quantidadePrescrita;
	}

	public CalculoHistoricoEntity(Date dataCalculo, String nomeUsuario, MedicamentoEntity medEntity,
			ViaAdministracaoEntity viaAdmEntity, BigDecimal quantidadePrescrita, BigDecimal quantidadeApresentada,
			String resultadosJson) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.dataCalculo = dataCalculo;
		this.medEntity = medEntity;
		this.viaAdmEntity = viaAdmEntity;
		this.quantidadePrescrita = quantidadePrescrita;
		this.quantidadeApresentada = quantidadeApresentada;
		this.resultadosJson = resultadosJson;
	}

}
