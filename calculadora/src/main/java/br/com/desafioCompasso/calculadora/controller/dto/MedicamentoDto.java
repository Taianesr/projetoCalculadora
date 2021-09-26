package br.com.desafioCompasso.calculadora.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicamentoDto {

	private Long id;
	private String nome;
	private Long idGrupoMedicamento;
	private Long idLaboratorio;
	private BigDecimal concentracaoInicial;
	private String embalagemApresentada;
	private String infoObservacao;
	private String infoSobra;
	private String infoTempoAdministracao;
	private BigDecimal quantidadeApresentacao;
	private String unidadeMedida;
	private List<DiluicaoConfiguracaoDto> lstDiluicao= new ArrayList<DiluicaoConfiguracaoDto>();

	


	public MedicamentoDto(Long id, String nome, Long idGrupoMedicamento, Long idLaboratorio,
			BigDecimal concentracaoInicial, String embalagemApresentada, String infoObservacao, String infoSobra,
			String infoTempoAdministracao, BigDecimal quantidadeApresentacao, String unidadeMedida,
			List<DiluicaoConfiguracaoDto> lstDiluicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idGrupoMedicamento = idGrupoMedicamento;
		this.idLaboratorio = idLaboratorio;
		this.concentracaoInicial = concentracaoInicial;
		this.embalagemApresentada = embalagemApresentada;
		this.infoObservacao = infoObservacao;
		this.infoSobra = infoSobra;
		this.infoTempoAdministracao = infoTempoAdministracao;
		this.quantidadeApresentacao = quantidadeApresentacao;
		this.unidadeMedida = unidadeMedida;
		this.lstDiluicao = lstDiluicao;
	}

	

	public void Converte(MedicamentoEntity medicamentoEntity, List<DiluicaoConfiguracaoDto> lstDiluicaoConfDto) {
		this.id = medicamentoEntity.getId();
		this.nome = medicamentoEntity.getNome();
		this.idGrupoMedicamento = medicamentoEntity.getGrupoMedicamento().getId();
		this.idLaboratorio = medicamentoEntity.getLaboratorio().getId();
		this.concentracaoInicial = medicamentoEntity.getConcentracaoInicial();
		this.embalagemApresentada = medicamentoEntity.getEmbalagemApresentada();
		this.infoObservacao = medicamentoEntity.getInfoObservacao();
		this.infoSobra = medicamentoEntity.getInfoSobra();
		this.infoTempoAdministracao = medicamentoEntity.getInfoTempoAdministracao();
		this.quantidadeApresentacao = medicamentoEntity.getQuantidadeApresentacao();
		this.unidadeMedida = medicamentoEntity.getUnidadeMedida();
		this.lstDiluicao= lstDiluicaoConfDto;


	}



	
}
