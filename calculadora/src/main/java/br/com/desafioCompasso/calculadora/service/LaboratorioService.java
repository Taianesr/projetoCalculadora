package br.com.desafioCompasso.calculadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.LaboratorioDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoLaboratorioForm;
import br.com.desafioCompasso.calculadora.controller.form.LaboratorioForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfig;
import br.com.desafioCompasso.calculadora.repository.LaboratorioRepository;


@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	@Autowired
	private ModelMapperConfig modelMapper;

	public List<LaboratorioEntity> listar() {
		return laboratorioRepository.findAll();
	}
	
	public LaboratorioEntity listarId(Long id) throws NotFoundException {
		LaboratorioEntity lab = laboratorioRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));
		
		return lab;
	}
	
	public LaboratorioEntity listarNome(String nome) throws NotFoundException {
		LaboratorioEntity lab = laboratorioRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse nome!"));
		
		return lab;
	}
	
	

	public LaboratorioDto criar(LaboratorioForm labForm) throws ServiceException {

		 Boolean lab= laboratorioRepository.findByNome(labForm.getNome()).isEmpty();		
				
         if(lab==true) {
        	LaboratorioEntity lab2 = modelMapper.modelMapper().map(labForm, LaboratorioEntity.class);
     		laboratorioRepository.save(lab2);
     		
     		return modelMapper.modelMapper().map(lab2, LaboratorioDto.class);
         }else {
        	 throw new ServiceException("Já existe um laboratório cadastrado com esse nome!");
         }
			
		
	}

	public LaboratorioDto atualizar(Long id, AtualizacaoLaboratorioForm atLabForm) throws NotFoundException {
		LaboratorioEntity lab = laboratorioRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));
		
		lab.setNome(atLabForm.getNome());
		
		return modelMapper.modelMapper().map(lab, LaboratorioDto.class);
	}
	
	
	public void excluir(Long  id) {
		LaboratorioEntity lab = laboratorioRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado o laboratório com esse id!"));
		
		laboratorioRepository.deleteById(id);
	}
	

}
