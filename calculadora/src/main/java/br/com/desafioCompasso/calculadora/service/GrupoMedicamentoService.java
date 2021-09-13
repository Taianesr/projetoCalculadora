package br.com.desafioCompasso.calculadora.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.GrupoMedicamentoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoGrupoMedicamentoForm;
import br.com.desafioCompasso.calculadora.controller.form.GrupoMedicamentoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.GrupoMedicamento;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfig;
import br.com.desafioCompasso.calculadora.repository.GrupoMedicamentoRepository;

@Service
public class GrupoMedicamentoService {

	@Autowired
	private GrupoMedicamentoRepository grupoMedicamentoRepository;

	@Autowired
	private ModelMapperConfig modelMapper;

	public List<GrupoMedicamento> listar() {
		return grupoMedicamentoRepository.findAll();
	}

	//mudar a classe de exception
	public GrupoMedicamentoDto criar(GrupoMedicamentoForm grupoMedForm) throws ServiceException {

		 Boolean grupoMed= grupoMedicamentoRepository.findByNome(grupoMedForm.getNome()).isEmpty();
		 
		 if(grupoMed==true) {
				GrupoMedicamento grupoMed2 = modelMapper.modelMapper().map(grupoMedForm, GrupoMedicamento.class);
				grupoMedicamentoRepository.save(grupoMed2);
				return modelMapper.modelMapper().map(grupoMed2, GrupoMedicamentoDto.class);
		 }else {
			 throw new ServiceException("Já existe um grupo medicamento cadastrado com esse nome!");
		 }
		 
	}

	public GrupoMedicamentoDto atualizar(Long id, AtualizacaoGrupoMedicamentoForm atGrupoMedForm)
			throws NotFoundException {

		GrupoMedicamento grupoMed = grupoMedicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));

		grupoMed.setNome(atGrupoMedForm.getNome());

		return modelMapper.modelMapper().map(grupoMed, GrupoMedicamentoDto.class);
	}

	
	public void excluir(Long id) {
		GrupoMedicamento grupoMed = grupoMedicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));
		
		grupoMedicamentoRepository.deleteById(id);
	}
	
	
}
