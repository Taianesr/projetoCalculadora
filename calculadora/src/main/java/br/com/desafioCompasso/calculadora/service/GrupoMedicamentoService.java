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
import br.com.desafioCompasso.calculadora.model.GrupoMedicamentoEntity;
import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigGrupoMed;
import br.com.desafioCompasso.calculadora.repository.GrupoMedicamentoRepository;

@Service
public class GrupoMedicamentoService {

	@Autowired
	private GrupoMedicamentoRepository grupoMedicamentoRepository;

	@Autowired
	private ModelMapperConfigGrupoMed modelMapper;

	public List<GrupoMedicamentoEntity> listar() {
		return grupoMedicamentoRepository.findAll();
	}
	

	public GrupoMedicamentoDto listarId(Long id) {
		GrupoMedicamentoEntity grupoMed = grupoMedicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));
		
		return modelMapper.modelMapperGrupoMed().map(grupoMed, GrupoMedicamentoDto.class);
		
	}
	
	
	public GrupoMedicamentoDto listarNome(String nome) {
		GrupoMedicamentoEntity grupoMed = grupoMedicamentoRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse nome!"));
		
		return modelMapper.modelMapperGrupoMed().map(grupoMed, GrupoMedicamentoDto.class);
		
	}
	
	

	//mudar a classe de exception
	public GrupoMedicamentoDto criar(GrupoMedicamentoForm grupoMedForm) throws ServiceException {

		 Boolean grupoMed= grupoMedicamentoRepository.findByNome(grupoMedForm.getNome()).isEmpty();
		 
		 if(grupoMed==true) {
				GrupoMedicamentoEntity grupoMed2 = modelMapper.modelMapperGrupoMed().map(grupoMedForm, GrupoMedicamentoEntity.class);
				grupoMedicamentoRepository.save(grupoMed2);
				return modelMapper.modelMapperGrupoMed().map(grupoMed, GrupoMedicamentoDto.class);
		 }else {
			 throw new ServiceException("Já existe um grupo medicamento cadastrado com esse nome!");
		 }
		 
	}

	public GrupoMedicamentoDto atualizar(Long id, AtualizacaoGrupoMedicamentoForm atGrupoMedForm)
			throws NotFoundException {

		GrupoMedicamentoEntity grupoMed = grupoMedicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));

		grupoMed.setNome(atGrupoMedForm.getNome());

		return modelMapper.modelMapperGrupoMed().map(grupoMed, GrupoMedicamentoDto.class);
	}

	
	public void excluir(Long id) {
		GrupoMedicamentoEntity grupoMed = grupoMedicamentoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o grupo medicamento com esse id!"));
		
		grupoMedicamentoRepository.deleteById(id);
	}
	
	
}
