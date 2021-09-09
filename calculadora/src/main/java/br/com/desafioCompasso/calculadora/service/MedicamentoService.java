package br.com.desafioCompasso.calculadora.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.MedicamentoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.MedicamentoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.GrupoMedicamento;
import br.com.desafioCompasso.calculadora.model.Laboratorio;
import br.com.desafioCompasso.calculadora.model.Medicamento;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfig;
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
	private ModelMapperConfig modelMapper;

	public List<Medicamento> listar() {
		return medicamentoRepository.findAll();
	}

	public MedicamentoDto criar(MedicamentoForm medForm) throws NotFoundException {

		Laboratorio lab = labRepository.findById(medForm.getLaboratorio_id())
				.orElseThrow(() -> new ServiceException("Não encontrado o laboratório com esse id!"));

		GrupoMedicamento grupoMed = grupoMedicamentoRepository.findById(medForm.getGrupo_medicamento_id())
				.orElseThrow(() -> new ServiceException("Não encontrado o grupo medicamento com esse id!"));

		Optional<Medicamento> med2 = medicamentoRepository.findByNomeAndGrupoMedicamentoIdAndLaboratorioId(
				medForm.getNome(), medForm.getGrupo_medicamento_id(), medForm.getLaboratorio_id());

		if (med2.isEmpty()) {
			Medicamento med = new Medicamento(grupoMed, lab, medForm.getNome());
			medicamentoRepository.save(med);
			return new MedicamentoDto(med);
		} else {
			throw new ServiceException("Medicamento já inserido!");

		}

	}

	public MedicamentoDto atualizar(BigInteger id, AtualizacaoMedicamentoForm atMedForm) throws NotFoundException {
		
		Laboratorio lab = labRepository.findById(atMedForm.getLaboratorio_id())
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));
		

		Medicamento med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse id!"));

		med.setNome(atMedForm.getNome());
		med.getLaboratorio().setId(atMedForm.getLaboratorio_id());

		return new MedicamentoDto(med);
	}
	
	
	public void excluir(BigInteger id) {

		Medicamento med = medicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o medicamento com esse id!"));

		
		medicamentoRepository.deleteById(id);
	}
	
	

}
