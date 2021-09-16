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
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfig;
import br.com.desafioCompasso.calculadora.repository.ViaAdministracaoRepository;

@Service
public class ViaAdministracaoService {
	
	@Autowired
	private ViaAdministracaoRepository viaAdministracaoRepository;

	@Autowired
	private ModelMapperConfig modelMapper;
	

	public List<ViaAdministracaoEntity> listar(){
		return viaAdministracaoRepository.findAll();
	}
	
	public ViaAdministracaoEntity listarId(Long id) throws NotFoundException {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrado a via administração com esse id!"));
		
		return viaAdm;
	}
	
	public ViaAdministracaoEntity listarNome(String nome) throws NotFoundException {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findByNome(nome)
				.orElseThrow(() -> new NotFoundException("Não encontrado a via administração com esse nome!"));
		
		return viaAdm;
	}
	
	public ViaAdministracaoDto criar(ViaAdministracaoForm viaAdmForm) throws ServiceException {

		 Boolean lab= viaAdministracaoRepository.findByNome(viaAdmForm.getNome()).isEmpty();		
				
       if(lab==true) {
      	ViaAdministracaoEntity viaAdm = modelMapper.modelMapper().map(viaAdmForm, ViaAdministracaoEntity.class);
      	viaAdministracaoRepository.save(viaAdm);
   		
   		return modelMapper.modelMapper().map(viaAdm, ViaAdministracaoDto.class);
       }else {
      	 throw new ServiceException("Já existe uma viaAdministracao cadastrada com esse nome!");
       }
			
		
	}
	
	public ViaAdministracaoDto atualizar(Long id, AtualizacaoViaAdministracaoForm atViaAdmForm) throws NotFoundException {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrada a viaAdministracao com esse id!"));
		
		viaAdm.setNome(atViaAdmForm.getNome());
		
		return modelMapper.modelMapper().map(viaAdm, ViaAdministracaoDto.class);
	}
	
	
	public void excluir(Long  id) {
		ViaAdministracaoEntity viaAdm = viaAdministracaoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrada a viaAdministracao com esse id!"));
		
		viaAdministracaoRepository.deleteById(id);
	}
	

	
	
	
	
}
