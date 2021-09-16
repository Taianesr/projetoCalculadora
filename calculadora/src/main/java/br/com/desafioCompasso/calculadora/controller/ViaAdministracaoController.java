package br.com.desafioCompasso.calculadora.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.desafioCompasso.calculadora.controller.dto.ViaAdministracaoDto;
import br.com.desafioCompasso.calculadora.controller.form.AtualizacaoViaAdministracaoForm;
import br.com.desafioCompasso.calculadora.controller.form.ViaAdministracaoForm;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;
import br.com.desafioCompasso.calculadora.service.ViaAdministracaoService;

@RestController
@RequestMapping("/via_administracao")
public class ViaAdministracaoController {
	
	@Autowired
	private ViaAdministracaoService viaAdministracaoService;
	

	@GetMapping("/listar")
	public List<ViaAdministracaoEntity> listarViaAdministracoes() {
		return viaAdministracaoService.listar();

	}
	
	//lista os laboratorios pelo id
	@GetMapping("/listar/{id}")
	public ViaAdministracaoEntity listarViaAdmsId(Long id){
		return viaAdministracaoService.listarId(id);
		
	}
	
	
	//lista os laboratorios pelo nome
		@GetMapping("/listar/{nome}")
		public ViaAdministracaoEntity listarViaAdmsId(String nome){
			return viaAdministracaoService.listarNome(nome);
			
		}
	
	
	@PostMapping("/criar")
	public ResponseEntity<ViaAdministracaoDto> criar(@RequestBody ViaAdministracaoForm viaAdmForm, UriComponentsBuilder uriBuilder) {
		
	    ViaAdministracaoDto viaAdmDto =  viaAdministracaoService.criar(viaAdmForm);
	    
	    URI uri= uriBuilder.path("/{id}/").buildAndExpand(viaAdmDto.getId()).toUri();
	    
		return ResponseEntity.created(uri).body(viaAdmDto);
		
	}
	
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity<ViaAdministracaoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoViaAdministracaoForm atViaAdmForm) throws ServiceException{
		
		ViaAdministracaoDto viaAdmDto =  viaAdministracaoService.atualizar(id, atViaAdmForm);
		
		return ResponseEntity.ok(viaAdmDto);
		
	}
	
	
	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id){
		viaAdministracaoService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
