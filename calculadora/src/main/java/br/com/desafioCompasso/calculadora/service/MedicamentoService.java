package br.com.desafioCompasso.calculadora.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.DiluicaoConfiguracaoDto;
import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.DiluicaoConfiguracaoForm;
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
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfig2;
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

	@Autowired
	private ModelMapperConfig2 modelMapper2;

	public List<MedicamentoDto> listar() {
		
		List<MedicamentoEntity> lstMed= medicamentoRepository.findAll();
		
		TypeToken<List<MedicamentoDto>> typeToken = new TypeToken<>() {};

		List<MedicamentoDto> medicamentoDtos = modelMapperConfigMedicamento.modelMapperMed().map(lstMed, typeToken.getType());
		
		return medicamentoDtos;
		
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

		Boolean med2 = medicamentoRepository.findByNomeAndGrupoMedicamentoIdAndLaboratorioId(medForm.getNome(),
				medForm.getIdGrupoMedicamento(), medForm.getIdLaboratorio()).isEmpty();

		List<DiluicaoConfiguracaoEntity> lstDiluicaoConfiguracao = new ArrayList<DiluicaoConfiguracaoEntity>();

		if (med2 == true) {
			// cria o objeto medicamento com os dados recebidos do form

			MedicamentoEntity med = new MedicamentoEntity(grupoMed, lab, medForm.getNome(),
					medForm.getConcentracaoInicial(), medForm.getEmbalagemApresentada(),
					medForm.getQuantidadeApresentacao(), medForm.getUnidadeMedida(), medForm.getInfoObs(),
					medForm.getInfoSobra(), medForm.getInfoTempoAdm());

			med = medicamentoRepository.save(med);
			
			
			for (DiluicaoConfiguracaoForm diluicaoConf2:  medForm.getDiluicaoConfiguracaoForm()) {

				ViaAdministracaoEntity viaAdm = viaAdmRepository
						.findById(diluicaoConf2.getIdViaAdministracao())
						.orElseThrow(() -> new NotFoundIdException("Não encontrado a via administração com esse id!"));

				lstDiluicaoConfiguracao = diluicaoConfRepository
						.findByMedicamentoIdAndViaAdministracaoIdOrderBySequenciaAsc(med.getId(), viaAdm.getId());

				DiluicaoConfiguracaoEntity diluicaoConf = new DiluicaoConfiguracaoEntity();
				diluicaoConf.setMedicamentoId(med.getId());
				diluicaoConf.setViaAdministracaoId(viaAdm.getId());
				diluicaoConf.setSequencia(diluicaoConf2.getSequencia());
				
				DiluicaoConfiguracaoEntityPK diluicaoConfPK = new DiluicaoConfiguracaoEntityPK(med, viaAdm,
					diluicaoConf2.getSequencia());
				
				diluicaoConf.setDiluicaoConfPK(diluicaoConfPK);
				
				diluicaoConf.setConcentracao(diluicaoConf2.getConcentracao());

				diluicaoConfRepository.save(diluicaoConf);
				
				diluicaoConf.setQuantidadeAdicionada(diluicaoConf2.getQuantidadeAdicionada());
				diluicaoConf.setQuantidadeAspirada(diluicaoConf2.getQuantidadeAspirada());

				diluicaoConf.setDiluente(diluicaoConf2.getDiluente());
				diluicaoConf.setModoPreparo(diluicaoConf2.getModoPreparo());

				lstDiluicaoConfiguracao.add(diluicaoConf);
				
			}
			
			
			
		

			List<DiluicaoConfiguracaoDto> lstDiluicaoConfDto = new ArrayList<DiluicaoConfiguracaoDto>();

		
			
			for (DiluicaoConfiguracaoEntity diluicaoConf3:lstDiluicaoConfiguracao ) {
				DiluicaoConfiguracaoDto diluicaoConfDto = modelMapperConfigDiluicaoConf.modelMapperDiluicaoConf()
						.map(diluicaoConf3, DiluicaoConfiguracaoDto.class);

				lstDiluicaoConfDto.add(diluicaoConfDto);
			}

			// adicionar metodo diluicaoConfigDto/medDto

			MedicamentoDto medDto2 = modelMapper2.modelMapper2().map(lstDiluicaoConfDto, MedicamentoDto.class);

			MedicamentoDto medDto = modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);
            medDto.setLstDiluicao(lstDiluicaoConfDto);
			
			return medDto;

		} else {
			throw new ServiceException("Medicamento já inserido!");

		}

	}
	

	public MedicamentoDto atualizar(Long id, AtualizacaoMedicamentoForm atMedForm) throws NotFoundIdException {

		LaboratorioEntity lab = labRepository.findById(atMedForm.getIdLaboratorio())
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o laboratório com esse id!"));

		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento com esse id!"));

		med.setNome(atMedForm.getNome());
		med.setConcentracaoInicial(atMedForm.getConcentracaoInicial());
		med.setEmbalagemApresentada(atMedForm.getEmbalagemApresentada());
		med.getGrupoMedicamento().setId(atMedForm.getIdGrupoMedicamento());
		med.getLaboratorio().setId(atMedForm.getIdLaboratorio());
		med.setInfoObservacao(atMedForm.getInfoObs());
		med.setInfoSobra(atMedForm.getInfoSobra());
		med.setInfoTempoAdministracao(atMedForm.getInfoTempoAdm());
		med.setQuantidadeApresentacao(atMedForm.getQuantidadeApresentacao());
		med.setUnidadeMedida(atMedForm.getUnidadeMedida());

		return modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);

	}

	public void excluir(Long id) throws NotFoundIdException {

		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o medicamento com esse id!"));

		medicamentoRepository.deleteById(id);
	}

}
