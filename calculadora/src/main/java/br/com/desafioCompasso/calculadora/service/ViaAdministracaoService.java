package br.com.desafioCompasso.calculadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioCompasso.calculadora.controller.dto.LaboratorioDto;
import br.com.desafioCompasso.calculadora.controller.dto.ViaAdministracaoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoLaboratorioForm;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoViaAdministracaoForm;
import br.com.desafioCompasso.calculadora.controller.form.LaboratorioForm;
import br.com.desafioCompasso.calculadora.controller.form.ViaAdministracaoForm;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundNameException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigViaAdm;
import br.com.desafioCompasso.calculadora.repository.ViaAdministracaoRepository;

@Service
public class ViaAdministracaoService {
	
	@Autowired
	private ViaAdministracaoRepository viaAdministracaoRepository;

	@Autowired
	private ModelMapperConfigViaAdm modelMapper;
	

	public List<ViaAdministracaoEntity> listar(){
		List<ViaAdministracaoEntity> lst= viaAdministracaoRepository.findAll();
	
		return lst;
	}
	
	public ViaAdministracaoDto listarId(Long id) throws NotFoundIdException {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrado a via administração com esse id!"));
		
		return modelMapper.modelMapperViaAdm().map(viaAdm, ViaAdministracaoDto.class);
	}
	
	public ViaAdministracaoDto listarNome(String nome) throws NotFoundNameException {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundNameException("Não encontrado a via administração com esse nome!"));
		
		return modelMapper.modelMapperViaAdm().map(viaAdm, ViaAdministracaoDto.class);
	}
	
	public ViaAdministracaoDto criar(ViaAdministracaoForm viaAdmForm) throws ServiceException {

		 Boolean lab= viaAdministracaoRepository.findByNome(viaAdmForm.getNome()).isEmpty();		
				
       if(lab==true) {
      	ViaAdministracaoEntity viaAdm = modelMapper.modelMapperViaAdm().map(viaAdmForm, ViaAdministracaoEntity.class);
      	viaAdministracaoRepository.save(viaAdm);
   		
   		return modelMapper.modelMapperViaAdm().map(viaAdm, ViaAdministracaoDto.class);
       }else {
      	 throw new ServiceException("Já existe uma viaAdministracao cadastrada com esse nome!");
       }
			
		
	}
	
	public ViaAdministracaoDto atualizar(Long id, AtualizacaoViaAdministracaoForm atViaAdmForm) throws NotFoundIdException {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrada a viaAdministracao com esse id!"));
		
		viaAdm.setNome(atViaAdmForm.getNome());
		
		return modelMapper.modelMapperViaAdm().map(viaAdm, ViaAdministracaoDto.class);
	}
	
	
	public void excluir(Long  id)throws NotFoundIdException {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findById(id)
				.orElseThrow(() -> new NotFoundIdException("Não encontrada a viaAdministracao com esse id!"));
		
		viaAdministracaoRepository.deleteById(id);
	}
	

	
}
