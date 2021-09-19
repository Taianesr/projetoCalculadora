package br.com.desafioCompasso.calculadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;

@Repository
public interface DiluicaoConfiguracaoRepository extends JpaRepository <DiluicaoConfiguracaoEntity, DiluicaoConfiguracaoEntityPK>  {
	
	
	
	
}
