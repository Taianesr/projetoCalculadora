package br.com.desafioCompasso.calculadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.MedicamentoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.GrupoMedicamentoEntity;
import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigMedicamento;
import br.com.desafioCompasso.calculadora.repository.GrupoMedicamentoRepository;
import br.com.desafioCompasso.calculadora.repository.LaboratorioRepository;
import br.com.desafioCompasso.calculadora.repository.MedicamentoRepository;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Autowired
	private GrupoMedicamentoRepository grupoMedicamentoRepository;

	@Autowired
	private LaboratorioRepository labRepository;

	@Autowired
	private ModelMapperConfigMedicamento modelMapperConfigMedicamento;

	public List<MedicamentoEntity> listar() {
		return medicamentoRepository.findAll();
	}
	
	public MedicamentoEntity listarId(Long id) throws NotFoundException {
		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse id!"));
		
		return med;
	}
	
	public MedicamentoEntity listarNome(String nome) throws NotFoundException {
		MedicamentoEntity med = medicamentoRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse nome!"));
		
		return med;
	}
	
	

	public MedicamentoDto criar(MedicamentoForm medForm) throws NotFoundException {

		LaboratorioEntity lab = labRepository.findById(medForm.getIdLaboratorio())
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));

		GrupoMedicamentoEntity grupoMed = grupoMedicamentoRepository.findById(medForm.getIdGrupoMedicamento())
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));

		Optional<MedicamentoEntity> med2 = medicamentoRepository.findByNomeAndGrupoMedicamentoIdAndLaboratorioId(
				medForm.getNome(), medForm.getIdGrupoMedicamento(), medForm.getIdLaboratorio());

		if (med2.isEmpty()) {
			MedicamentoEntity med = new MedicamentoEntity(grupoMed, lab, medForm.getNome());
			medicamentoRepository.save(med);
		    
			return modelMapperConfigMedicamento.modelMapper2().map(med, MedicamentoDto.class);
			
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
		
		return modelMapperConfigMedicamento.modelMapper2().map(med, MedicamentoDto.class);
	
	}
	
	
	public void excluir(Long id) {

		MedicamentoEntity med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse id!"));

		
		medicamentoRepository.deleteById(id);
	}
	
	

}
