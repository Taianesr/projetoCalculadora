package br.com.undefined.calculadora.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.undefined.calculadora.controller.form.AtualizacaoGrupoMedicamentoForm;
import br.com.undefined.calculadora.controller.form.GrupoMedicamentoForm;
import br.com.undefined.calculadora.dto.GrupoMedicamentoDto;
import br.com.undefined.calculadora.exceptions.ServiceException;
import br.com.undefined.calculadora.model.Grupo_medicamento;
import br.com.undefined.calculadora.modelMapper.ModelMapperConfig;
import br.com.undefined.calculadora.repository.GrupoMedicamentoRepository;

@Service
public class GrupoMedicamentoService {

	@Autowired
	private GrupoMedicamentoRepository grupoMedicamentoRepository;

	@Autowired
	private ModelMapperConfig modelMapper;

	public List<Grupo_medicamento> listar() {
		return grupoMedicamentoRepository.findAll();
	}

	public Grupo_medicamento criar(GrupoMedicamentoForm grupoMedForm) throws ServiceException {

		// Grupo_medicamento grupoMed=
		// grupoMedicamentoRepository.findByNome(grupoMedForm.getNome()).orElseThrow(()
		// -> new ServiceException("Já existe um grupo medicamento com esse nome!"));

		Grupo_medicamento grupoMed2 = modelMapper.modelMapper().map(grupoMedForm, Grupo_medicamento.class);
		grupoMedicamentoRepository.save(grupoMed2);
		return grupoMed2;

	}

	public GrupoMedicamentoDto atualizar(BigInteger id, AtualizacaoGrupoMedicamentoForm atGrupoMedForm)
			throws ServiceException {

		Grupo_medicamento grupoMed = grupoMedicamentoRepository.findById(id)
				.orElseThrow(() -> new ServiceException("Não encontrado grupo medicamento com esse id!"));

		grupoMed.setNome(atGrupoMedForm.getNome());

		return modelMapper.modelMapper().map(grupoMed, GrupoMedicamentoDto.class);
	}

}
