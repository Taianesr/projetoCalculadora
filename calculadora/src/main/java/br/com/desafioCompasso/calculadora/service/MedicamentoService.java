package br.com.desafioCompasso.calculadora.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.DiluicaoConfiguracaoDto;
import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.MedicamentoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundNameException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;
import br.com.desafioCompasso.calculadora.model.GrupoMedicamentoEntity;
import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigDiluicao;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigMedicamento;
import br.com.desafioCompasso.calculadora.repository.DiluicaoConfiguracaoRepository;
import br.com.desafioCompasso.calculadora.repository.GrupoMedicamentoRepository;
import br.com.desafioCompasso.calculadora.repository.LaboratorioRepository;
import br.com.desafioCompasso.calculadora.repository.MedicamentoRepository;
import br.com.desafioCompasso.calculadora.repository.ViaAdministracaoRepository;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Autowired
	private GrupoMedicamentoRepository grupoMedicamentoRepository;

	@Autowired
	private LaboratorioRepository labRepository;

	@Autowired
	private ViaAdministracaoRepository viaAdmRepository;

	@Autowired
	private DiluicaoConfiguracaoRepository diluicaoConfRepository;

	@Autowired
	private ModelMapperConfigMedicamento modelMapperConfigMedicamento;

	@Autowired
	private ModelMapperConfigDiluicao modelMapperConfigDiluicaoConf;

	public List<MedicamentoEntity> listar() {
		return medicamentoRepository.findAll();
	}

	public MedicamentoDto listarId(Long id) throws NotFoundIdException {
		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento com esse id!"));

		return modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);
	}

	public MedicamentoDto listarNome(String nome) throws NotFoundNameException {
		MedicamentoEntity med = medicamentoRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundNameException("Não encontrado o medicamento com esse nome!"));

		return modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);
	}

	public MedicamentoDto criar(MedicamentoForm medForm) throws NotFoundIdException {

		LaboratorioEntity lab = labRepository.findById(medForm.getIdLaboratorio())
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));

		GrupoMedicamentoEntity grupoMed = grupoMedicamentoRepository.findById(medForm.getIdGrupoMedicamento())
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));

		// revisar
		Boolean med2 = medicamentoRepository.findByNomeAndGrupoMedicamentoIdAndLaboratorioId(medForm.getNome(),
				medForm.getIdGrupoMedicamento(), medForm.getIdLaboratorio()).isEmpty();

		
		List<DiluicaoConfiguracaoEntity> lstDiluicaoConfiguracao = new ArrayList<DiluicaoConfiguracaoEntity>();

		if (med2 == true) {
			// cria o objeto medicamento com os dados recebidos do form

			MedicamentoEntity med = new MedicamentoEntity(grupoMed, lab, medForm.getNome(),
					medForm.getConcentracaoInicial(), medForm.getEmbalagemApresentada(),
					medForm.getQuantidadeApresentacao(), medForm.getUnidadeMedida(), medForm.getInfoObs(),
					medForm.getInfoSobra(), medForm.getInfoTempoAdm());

			List<DiluicaoConfiguracaoEntity> lstDiluicao = new ArrayList<DiluicaoConfiguracaoEntity>();

			// salva as diluicoes configurações no repository
			for (int i = 0; i < medForm.getDiluicaoConfiguracaoForm().size(); i++) {

				ViaAdministracaoEntity viaAdm = viaAdmRepository
						.findById(medForm.getDiluicaoConfiguracaoForm().get(i).getIdViaAdministracao())
						.orElseThrow(() -> new NotFoundIdException("Não encontrado a via administração com esse id!"));

				lstDiluicaoConfiguracao = diluicaoConfRepository
						.findByMedicamentoIdAndViaAdministracaoIdOrderBySequenciaAsc(med.getId(), viaAdm.getId());

				DiluicaoConfiguracaoEntity conf3 = new DiluicaoConfiguracaoEntity();
				conf3.setMedicamentoId(med.getId());
				conf3.setViaAdministracaoId(viaAdm.getId());
				conf3.setSequencia(medForm.getDiluicaoConfiguracaoForm().get(i).getSequencia());
				conf3.setQuantidadeAdicionada(medForm.getDiluicaoConfiguracaoForm().get(i).getQuantidadeAdicionada());
				conf3.setQuantidadeAspirada(medForm.getDiluicaoConfiguracaoForm().get(i).getQuantidadeAspirada());
				conf3.setConcentracao(medForm.getDiluicaoConfiguracaoForm().get(i).getConcentracao());
				conf3.setDiluente(medForm.getDiluicaoConfiguracaoForm().get(i).getDiluente());
				conf3.setModoPreparo(medForm.getDiluicaoConfiguracaoForm().get(i).getModoPreparo());

				lstDiluicaoConfiguracao.add(conf3);

				diluicaoConfRepository.save(lstDiluicaoConfiguracao.get(i));

			}

			List<DiluicaoConfiguracaoDto> lstDiluicaoConfDto = new ArrayList<DiluicaoConfiguracaoDto>();

			// trasnforma a lista de diluicoes configuracoes em dtos
			for (int i = 0; i < lstDiluicaoConfiguracao.size(); i++) {
				DiluicaoConfiguracaoDto diluicaoConfDto = modelMapperConfigDiluicaoConf.modelMapperDiluicaoConf()
						.map(lstDiluicaoConfiguracao.get(i), DiluicaoConfiguracaoDto.class);

				lstDiluicaoConfDto.add(diluicaoConfDto);
			}

			MedicamentoDto medDto = new MedicamentoDto();

			medicamentoRepository.save(med);

			medDto.Converte(med, lstDiluicaoConfDto);

			return medDto;

		} else {
			throw new ServiceException("Medicamento já inserido!");

		}

	}

	
	public MedicamentoDto atualizar(Long id, AtualizacaoMedicamentoForm atMedForm) throws NotFoundIdException {

		LaboratorioEntity lab = labRepository.findById(atMedForm.getLaboratorio_id())
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o laboratório com esse id!"));

		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento com esse id!"));

		med.setNome(atMedForm.getNome());
		med.getLaboratorio().setId(atMedForm.getLaboratorio_id());

		return modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);

	}

	
	public void excluir(Long id) throws NotFoundIdException {

		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento com esse id!"));

		medicamentoRepository.deleteById(id);
	}

}
