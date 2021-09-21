package br.com.desafioCompasso.calculadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;
import br.com.desafioCompasso.calculadora.modelMapper.ModelMapperConfigDiluicao;
import br.com.desafioCompasso.calculadora.repository.DiluicaoConfiguracaoRepository;

@Service
public class DiluicaoConfiguracaoService {
	
	@Autowired
	private DiluicaoConfiguracaoRepository diluicaoConfRepository;
	
	@Autowired
	private ModelMapperConfigDiluicao modelMapper;

	public List<DiluicaoConfiguracaoEntity> listar() {
		return diluicaoConfRepository.findAll();
	}
	

	public void excluir(DiluicaoConfiguracaoEntityPK id)throws NotFoundException  {
		DiluicaoConfiguracaoEntity diluicaoConf = diluicaoConfRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não encontrada a diluicao configuracao com esse id!"));
		
		diluicaoConfRepository.deleteById(id);
	}
	
	
	
	

}
