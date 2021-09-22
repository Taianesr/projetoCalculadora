package br.com.desafioCompasso.calculadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DiluicaoConfiguracaoEntityPK implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicamento_id", referencedColumnName = "id")
	private MedicamentoEntity medicamento;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "via_administracao_id", referencedColumnName = "id")
	private ViaAdministracaoEntity viaAdministracao;
	@Column(name="sequencia")
	private int sequencia;

	public DiluicaoConfiguracaoEntityPK() {
		super();
	}

	public DiluicaoConfiguracaoEntityPK(MedicamentoEntity medicamento, ViaAdministracaoEntity viaAdministracao,
			int sequencia) {
		super();
		this.medicamento = medicamento;
		this.viaAdministracao = viaAdministracao;
		this.sequencia = sequencia;
	}

	public MedicamentoEntity getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(MedicamentoEntity medicamento) {
		this.medicamento = medicamento;
	}

	public ViaAdministracaoEntity getViaAdministracao() {
		return viaAdministracao;
	}

	public void setViaAdministracao(ViaAdministracaoEntity viaAdministracao) {
		this.viaAdministracao = viaAdministracao;
	}

	public int getSequencia() {
		return sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
	
}