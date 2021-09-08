package br.com.undefined.calculadora.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.undefined.calculadora.controller.form.AtualizacaoLaboratorioForm;
import br.com.undefined.calculadora.controller.form.LaboratorioForm;
import br.com.undefined.calculadora.dto.LaboratorioDto;
import br.com.undefined.calculadora.exceptions.ServiceException;
import br.com.undefined.calculadora.model.Laboratorio;
import br.com.undefined.calculadora.modelMapper.ModelMapperConfig;
import br.com.undefined.calculadora.repository.LaboratorioRepository;


@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	@Autowired
	private ModelMapperConfig modelMapper;

	public List<Laboratorio> listar() {
		return laboratorioRepository.findAll();
	}

	public LaboratorioDto criar(LaboratorioForm labForm) throws ServiceException {
		// classse mapper

		 Boolean lab= laboratorioRepository.findByNome(labForm.getNome()).isEmpty();		
				
         if(lab==true) {
        	Laboratorio lab2 = modelMapper.modelMapper().map(labForm, Laboratorio.class);
     		laboratorioRepository.save(lab2);
     		
     		return modelMapper.modelMapper().map(lab2, LaboratorioDto.class);
         }else {
        	 throw new ServiceException("Já existe um laboratório cadastrado com esse nome!");
         }
		
		
		
	}

	public LaboratorioDto atualizar(BigInteger id, AtualizacaoLaboratorioForm atLabForm) throws ServiceException {
		Laboratorio lab = laboratorioRepository.findById(id)
				.orElseThrow(() -> new ServiceException("Não encontrado o laboratório com esse id!"));

		lab.setNome(atLabForm.getNome());

		return modelMapper.modelMapper().map(lab, LaboratorioDto.class);
	}
	
	
	public void excluir(BigInteger id) {
		laboratorioRepository.deleteById(id);
	}
	

}
