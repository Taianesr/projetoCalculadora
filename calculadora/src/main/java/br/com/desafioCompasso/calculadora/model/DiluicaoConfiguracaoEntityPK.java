package br.com.desafioCompasso.calculadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiluicaoConfiguracaoEntityPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicamento_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private MedicamentoEntity medicamento;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "via_administracao_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private ViaAdministracaoEntity viaAdministracao;
	@Column(name = "sequencia", nullable = false, insertable = false, updatable = false)
	private int sequencia;

	public DiluicaoConfiguracaoEntityPK(MedicamentoEntity medicamento, ViaAdministracaoEntity viaAdministracao,
			int sequencia) {
		super();
		this.medicamento = medicamento;
		this.viaAdministracao = viaAdministracao;
		this.sequencia = sequencia;
	}

}