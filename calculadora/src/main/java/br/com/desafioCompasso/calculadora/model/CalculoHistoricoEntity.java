package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="calculo_historico")
public class CalculoHistoricoEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//ou date time?
	private Date dataCalculo;
	private String nomeUsuario;

	@ManyToOne
	@JoinColumn(name = "medicamento_id", referencedColumnName = "id" )
	private MedicamentoEntity medEntity;
	
	//nao sei se devo usar essa anotação
    @OneToOne
	@JoinColumn(name = "via_administracao_id", referencedColumnName = "id" )
	private ViaAdministracaoEntity viaAdmEntity;
	
	private BigDecimal quantidadePrescrita;
	private String resultadosJson;

	
	
	public CalculoHistoricoEntity() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDataCalculo() {
		return dataCalculo;
	}



	public void setDataCalculo(Date dataCalculo) {
		this.dataCalculo = dataCalculo;
	}



	public String getNomeUsuario() {
		return nomeUsuario;
	}



	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}



	public MedicamentoEntity getMedEntity() {
		return medEntity;
	}



	public void setMedEntity(MedicamentoEntity medEntity) {
		this.medEntity = medEntity;
	}



	public ViaAdministracaoEntity getViaAdmEntity() {
		return viaAdmEntity;
	}



	public void setViaAdmEntity(ViaAdministracaoEntity viaAdmEntity) {
		this.viaAdmEntity = viaAdmEntity;
	}



	public BigDecimal getQuantidadePrescrita() {
		return quantidadePrescrita;
	}



	public void setQuantidadePrescrita(BigDecimal quantidadePrescrita) {
		this.quantidadePrescrita = quantidadePrescrita;
	}



	public String getResultadosJson() {
		return resultadosJson;
	}



	public void setResultadosJson(String resultadosJson) {
		this.resultadosJson = resultadosJson;
	}

	


}
