package br.com.desafioCompasso.calculadora.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.CalculoDto;
import br.com.desafioCompasso.calculadora.controller.dto.CalculoHistoricoDto;
import br.com.desafioCompasso.calculadora.controller.form.CalculoHistoricoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigCalcHistorico;
import br.com.desafioCompasso.calculadora.repository.CalculoHistoricoRepository;
import br.com.desafioCompasso.calculadora.repository.DiluicaoConfiguracaoRepository;
import br.com.desafioCompasso.calculadora.repository.MedicamentoRepository;
import br.com.desafioCompasso.calculadora.repository.ViaAdministracaoRepository;

@Service
public class CalculoHistoricoService {

	@Autowired
	private CalculoHistoricoRepository calculoHistoricoRepository;

	@Autowired
	private ViaAdministracaoRepository viaAdmRepository;

	@Autowired
	private MedicamentoRepository medRepository;

	@Autowired
	private DiluicaoConfiguracaoRepository diluicaoConfRepository;

	@Autowired
	private ModelMapperConfigCalcHistorico modelMapper;

	public CalculoDto criar(CalculoHistoricoForm calcHistoricoForm) throws NotFoundIdException {

		MedicamentoEntity med = medRepository.findById(calcHistoricoForm.getIdMedicamento())
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento pelo id!"));

		ViaAdministracaoEntity viaAdm = viaAdmRepository.findById(calcHistoricoForm.getIdViaAdministracao())
				.orElseThrow(() -> new NotFoundIdException("Não encontrado a via administracao pelo id!"));

		CalculoHistoricoEntity calcHistorico = new CalculoHistoricoEntity(calcHistoricoForm.getNomeUsuario(), med,
				viaAdm, calcHistoricoForm.getQuantidadePrescrita());

		CalculoDto calcDto = listarInfo(med, viaAdm, calcHistorico);

		calculoHistoricoRepository.save(calcHistorico);

		return calcDto;

	}

	// public List<CalculoHistoricoDto> listar(Long id, Date dataIni, Date dataFim)
	// {

	// List<CalculoHistoricoEntity> lstCalcHistorico =
	// calculoHistoricoRepository.findAllByDataCalculoBetween(dataIni,
	// dataFim);

	// TypeToken<List<CalculoHistoricoDto>> typeToken = new TypeToken<>() {
	// };

	// List<CalculoHistoricoDto> calcHistoricoDtos =
	// modelMapper.modelMapperCalcHistorico().map(lstCalcHistorico,
	// typeToken.getType());

	// return calcHistoricoDtos;

	// }

	public List<CalculoHistoricoDto> listar(Long id, Date dataIni, Date dataFim) {

		String nome = "";

		if (id != null) {
			MedicamentoEntity med = getMedicamento(id);
			nome = med.getNome();

		}

		List<CalculoHistoricoEntity> historico= filtro(nome, dataIni, dataFim);

		//List<CalculoHistoricoEntity> lstCalcHistorico = calculoHistoricoRepository.findAllByDataCalculoBetween(dataIni,
		//		dataFim);
		
		if (historico.isEmpty()) {
			throw new RuntimeException("Não foram encontrados resultados para os parametros informados!");
		}

		TypeToken<List<CalculoHistoricoDto>> typeToken = new TypeToken<>() {
		};

		List<CalculoHistoricoDto> calcHistoricoDtos = modelMapper.modelMapperCalcHistorico().map(historico,
				typeToken.getType());

		return calcHistoricoDtos;

	}

	
	public CalculoDto listarInfo(MedicamentoEntity med, ViaAdministracaoEntity viaAdm,
			CalculoHistoricoEntity calcHistorico) {

		List<DiluicaoConfiguracaoEntity> lstDiluicaoConf = diluicaoConfRepository
				.findByMedicamentoIdAndViaAdministracaoIdOrderBySequenciaAsc(med.getId(), viaAdm.getId());

		List<String> msgPassosAdministracao = new ArrayList<String>();
		List<String> infoList = new ArrayList<String>();
		String infoAdministracao = "";

		BigDecimal concentracaoFinal = BigDecimal.ZERO;

		for (DiluicaoConfiguracaoEntity diluicaoConfiguracaoEntity : lstDiluicaoConf) {
			msgPassosAdministracao.add(diluicaoConfiguracaoEntity.getModoPreparo());
			concentracaoFinal = diluicaoConfiguracaoEntity.getConcentracao();
		}

		if (lstDiluicaoConf.isEmpty()) {
			concentracaoFinal = med.getConcentracaoInicial();
		}

		infoList.add("Info Sobra: " + med.getInfoSobra());
		infoList.add("Tempo de administracao: " + med.getInfoTempoAdministracao());
		infoList.add("Observação: " + med.getInfoObservacao());

		BigDecimal result = calcHistorico.getQuantidadePrescrita().divide(concentracaoFinal, 2, RoundingMode.HALF_UP);

		infoAdministracao = "Aspire " + result;

		CalculoDto calcDto = new CalculoDto(infoAdministracao, msgPassosAdministracao, infoList);

		return calcDto;

	}

	public MedicamentoEntity getMedicamento(Long id) {
		MedicamentoEntity med = medRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento pelo id!"));

		return med;
	}

	///
	
	
	public List<CalculoHistoricoEntity> filtro(String nome, Date dataIni, Date dataFim) {
		if (!nome.isEmpty() && dataIni != null && dataFim != null ) {
			List<CalculoHistoricoEntity> lstCalcHistorico= calculoHistoricoRepository.
					findAllByMedEntityNomeAndDataCalculoBetween(nome, dataIni, dataFim);
		}else if(!nome.isEmpty()) {
			List<CalculoHistoricoEntity> lstCalcHistorico = calculoHistoricoRepository.findByMedEntityNome(nome);
		}
		else if (dataIni != null && dataFim != null) {
			List<CalculoHistoricoEntity> lstCalcHistorico = calculoHistoricoRepository
					.findAllByDataCalculoBetween(dataIni, dataFim);
		}
		
		throw new RuntimeException("Valores do filtro errados");

	}
}
