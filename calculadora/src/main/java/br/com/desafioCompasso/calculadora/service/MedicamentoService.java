package br.com.desafioCompasso.calculadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.DiluicaoConfiguracaoDto;
import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.MedicamentoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
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
	
	public MedicamentoDto listarId(Long id) throws NotFoundException {
		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse id!"));
		
		return modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);
	}
	
	public MedicamentoDto listarNome(String nome) throws NotFoundException {
		MedicamentoEntity med = medicamentoRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse nome!"));
	
		return modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);
	}
	
	

	public MedicamentoDto criar(MedicamentoForm medForm) throws NotFoundException {

		LaboratorioEntity lab = labRepository.findById(medForm.getIdLaboratorio())
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));

		GrupoMedicamentoEntity grupoMed = grupoMedicamentoRepository.findById(medForm.getIdGrupoMedicamento())
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));

	
		
		Optional<MedicamentoEntity> med2 = medicamentoRepository.findByNomeAndGrupoMedicamentoIdAndLaboratorioId(
				medForm.getNome(), medForm.getIdGrupoMedicamento(), medForm.getIdLaboratorio());
		
		
		if (med2.isEmpty()) {
			//cria o objeto medicamento com os dados recebidos do form
			
			MedicamentoEntity med = new MedicamentoEntity(grupoMed, lab, medForm.getNome(), medForm.getConcentracaoInicial(), medForm.getEmbalagemApresentada(), medForm.getQuantidadeApresentacao()
					, medForm.getUnidadeMedida(), medForm.getInfoObs(), medForm.getInfoSobra(), medForm.getInfoTempoAdm());
			
			
			List <DiluicaoConfiguracaoEntity> lstDiluicao = null;
			
			
			//salva as diluicoes configurações no repository
			for (int i=0; i< medForm.getDiluicaoConfiguracaoForm().size(); i++) {
			
				
				ViaAdministracaoEntity viaAdm = viaAdmRepository.findById(medForm.getDiluicaoConfiguracaoForm().get(i).getIdViaAdministracao())
						.orElseThrow(() -> new NotFoundException("Não encontrado a via administração com esse id!"));
				
				
				DiluicaoConfiguracaoEntityPK diluicaoConfPK= new DiluicaoConfiguracaoEntityPK (med, viaAdm, medForm.getDiluicaoConfiguracaoForm().get(i).getSequencia() );
				
				DiluicaoConfiguracaoEntity diluicaoConf= new DiluicaoConfiguracaoEntity(diluicaoConfPK,  medForm.getDiluicaoConfiguracaoForm().get(i).getQuantidadeAspirada(), 
						medForm.getDiluicaoConfiguracaoForm().get(i).getQuantidadeAdicionada(), medForm.getDiluicaoConfiguracaoForm().get(i).getConcentracao(), 
						medForm.getDiluicaoConfiguracaoForm().get(i).getDiluente(), medForm.getDiluicaoConfiguracaoForm().get(i).getModoPreparo());
				
				
				lstDiluicao.add(diluicaoConf);
				
				diluicaoConfRepository.save(diluicaoConf);
			
				
			}
			

			
			List<DiluicaoConfiguracaoDto> lstDiluicaoConfDto= null;
			

            //trasnforma a lista de diluicoes configuracoes em dtos			
			for (int i=0; i< lstDiluicao.size() ; i++) {
				DiluicaoConfiguracaoDto diluicaoConfDto=  modelMapperConfigDiluicaoConf.modelMapperDiluicaoConf().map(lstDiluicao.get(i), DiluicaoConfiguracaoDto.class);
				
				lstDiluicaoConfDto.add(diluicaoConfDto);
			}
			

			
			MedicamentoDto medDto = new MedicamentoDto();
	
            medDto.Converte(med, lstDiluicaoConfDto);
			
			
			medicamentoRepository.save(med);
		    
			return medDto;
		
			
		} else {
			throw new ServiceException("Medicamento já inserido!");

		}

	}
	

	public MedicamentoDto atualizar(Long id, AtualizacaoMedicamentoForm atMedForm) throws NotFoundException {
		
		LaboratorioEntity lab = labRepository.findById(atMedForm.getLaboratorio_id())
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));
		

		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse id!"));

		med.setNome(atMedForm.getNome());
		med.getLaboratorio().setId(atMedForm.getLaboratorio_id());
		
		return modelMapperConfigMedicamento.modelMapperMed().map(med, MedicamentoDto.class);
	
	}
	
	
	public void excluir(Long id) {

		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse id!"));

		
		medicamentoRepository.deleteById(id);
	}
	
	

}
