package br.com.undefined.calculadora.service;

import java.math.BigInteger;
import java.util.List;

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

	public GrupoMedicamentoDto criar(GrupoMedicamentoForm grupoMedForm) throws ServiceException {

		 Boolean grupoMed= grupoMedicamentoRepository.findByNome(grupoMedForm.getNome()).isEmpty();
		 
		 if(grupoMed==true) {
				Grupo_medicamento grupoMed2 = modelMapper.modelMapper().map(grupoMedForm, Grupo_medicamento.class);
				grupoMedicamentoRepository.save(grupoMed2);
				return modelMapper.modelMapper().map(grupoMed2, GrupoMedicamentoDto.class);
		 }else {
			 throw new ServiceException("Já existe um grupo medicamento cadastrado com esse nome!");
		 }
		 

	

	}

	public GrupoMedicamentoDto atualizar(BigInteger id, AtualizacaoGrupoMedicamentoForm atGrupoMedForm)
			throws ServiceException {

		Grupo_medicamento grupoMed = grupoMedicamentoRepository.findById(id)
				.orElseThrow(() -> new ServiceException("Não encontrado o grupo medicamento com esse id!"));

		grupoMed.setNome(atGrupoMedForm.getNome());

		return modelMapper.modelMapper().map(grupoMed, GrupoMedicamentoDto.class);
	}

	
	public void excluir(BigInteger id) {
		grupoMedicamentoRepository.deleteById(id);
	}
	
	
}
