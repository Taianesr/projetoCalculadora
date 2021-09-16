package br.com.desafioCompasso.calculadora.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="calculo_historico")
public class CalculoHistoricoEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//ou date time?
	private Date dataCalculo;
	private String nomeUsuario;
	private Long idMedicamento;
	private ViaAdministracaoEntity viaAdmEntity;
	private BigDecimal quantidadePrescrita;
	private String resultadosJson;
	// falta parametro ? private String viaAdministracao; 
	
	public CalculoHistoricoEntity() {
		super();
	}


	public CalculoHistoricoEntity(Long id, Date dataCalculo, String nomeUsuario, Long idMedicamento,
			ViaAdministracaoEntity viaAdmEntity, BigDecimal quantidadePrescrita, String resultadosJson) {
		super();
		this.id = id;
		this.dataCalculo = dataCalculo;
		this.nomeUsuario = nomeUsuario;
		this.idMedicamento = idMedicamento;
		this.viaAdmEntity = viaAdmEntity;
		this.quantidadePrescrita = quantidadePrescrita;
		this.resultadosJson = resultadosJson;
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


	public Long getIdMedicamento() {
		return idMedicamento;
	}


	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}


	public ViaAdministracaoEntity getViaAdmEntity() {
		return viaAdmEntity;
	}


	public void setViaAdmEntity(ViaAdministracaoEntity viaAdmEntity) {
		this.viaAdmEntity = viaAdmEntity;
	}

	public String getResultadosJson() {
		return resultadosJson;
	}


	public void setResultadosJson(String resultadosJson) {
		this.resultadosJson = resultadosJson;
	}
	
	
	
	
	
	
	
	


}
