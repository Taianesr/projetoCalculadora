package br.com.desafioCompasso.calculadora.service;



import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.desafioCompasso.calculadora.controller.dto.LaboratorioDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoLaboratorioForm;
import br.com.desafioCompasso.calculadora.controller.form.LaboratorioForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundNameException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigLaboratorio;
import br.com.desafioCompasso.calculadora.repository.LaboratorioRepository;


@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	@Autowired
	private ModelMapperConfigLaboratorio modelMapper;

	public List<LaboratorioDto> listar() {
		List<LaboratorioEntity> lstLab= laboratorioRepository.findAll();
		
		TypeToken<List<LaboratorioDto>> typeToken = new TypeToken<>() {
		};

		List<LaboratorioDto> laboratorioDtos = modelMapper.modelMapperLab().map(lstLab, typeToken.getType());

		return laboratorioDtos;
	}
	
	public LaboratorioDto listarId(Long id) throws NotFoundIdException {
		LaboratorioEntity lab = laboratorioRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o laboratório com esse id!"));
		
		return modelMapper.modelMapperLab().map(lab, LaboratorioDto.class);
	}
	
	public LaboratorioDto listarNome(String nome) throws NotFoundNameException {
		LaboratorioEntity lab = laboratorioRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundNameException("Não encontrado o laboratório com esse nome!"));
		
		return modelMapper.modelMapperLab().map(lab, LaboratorioDto.class);
	}
	
	

	public LaboratorioDto criar(LaboratorioForm labForm) throws ServiceException {

		 Boolean lab= laboratorioRepository.findByNome(labForm.getNome()).isEmpty();		
				
         if(lab==true) {
        	LaboratorioEntity lab2 = modelMapper.modelMapperLab().map(labForm, LaboratorioEntity.class);
     		laboratorioRepository.save(lab2);
     		
     		return modelMapper.modelMapperLab().map(lab2, LaboratorioDto.class);
         }else {
        	 throw new ServiceException("Já existe um laboratório cadastrado com esse nome!");
         }
			
		
	}

	
	public LaboratorioDto atualizar(Long id, AtualizacaoLaboratorioForm atLabForm) throws NotFoundIdException {
		LaboratorioEntity lab = laboratorioRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o laboratório com esse id!"));
		
		lab.setNome(atLabForm.getNome());
		
		return modelMapper.modelMapperLab().map(lab, LaboratorioDto.class);
	}
	
	
	public void excluir(Long  id) throws NotFoundIdException{
		LaboratorioEntity lab = laboratorioRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado o laboratório com esse id!"));
		
		laboratorioRepository.deleteById(id);
	}
	

}
