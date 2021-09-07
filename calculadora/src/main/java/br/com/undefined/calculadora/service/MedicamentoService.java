package br.com.undefined.calculadora.service;

import java.math.BigInteger;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.undefined.calculadora.controller.form.AtualizacaoMedicamentoForm;
import br.com.undefined.calculadora.controller.form.MedicamentoForm;
import br.com.undefined.calculadora.dto.MedicamentoDto;
import br.com.undefined.calculadora.exceptions.ServiceException;
import br.com.undefined.calculadora.model.Grupo_medicamento;
import br.com.undefined.calculadora.model.Laboratorio;
import br.com.undefined.calculadora.model.Medicamento;
import br.com.undefined.calculadora.modelMapper.ModelMapperConfig;
import br.com.undefined.calculadora.repository.GrupoMedicamentoRepository;
import br.com.undefined.calculadora.repository.LaboratorioRepository;
import br.com.undefined.calculadora.repository.MedicamentoRepository;


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

	public Medicamento criar(MedicamentoForm medForm) throws ServiceException {

		Laboratorio lab = labRepository.findById(medForm.getLaboratorio_id())
				.orElseThrow(() -> new ServiceException("Não encontrado laboratório com esse id!"));

		Grupo_medicamento grupoMed = grupoMedicamentoRepository.findById(medForm.getGrupo_medicamento_id())
				.orElseThrow(() -> new ServiceException("Não encontrado grupo medicamento com esse id!"));
		

		Medicamento med = new Medicamento(grupoMed, lab, medForm.getNome());
		medicamentoRepository.save(med);
		return med;
	}

	public MedicamentoDto atualizar(BigInteger id, AtualizacaoMedicamentoForm atMedForm) throws ServiceException {
		
		Medicamento med= medicamentoRepository.findById(id).orElseThrow(() -> new ServiceException("Não encontrado medicamento com esse id!"));

		med.setNome(atMedForm.getNome());
		med.getLaboratorio().setId(atMedForm.getLaboratorio_id());

		// mudar comando
		return new MedicamentoDto(med);
	}

}
