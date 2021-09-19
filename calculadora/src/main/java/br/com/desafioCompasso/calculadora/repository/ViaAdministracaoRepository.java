package br.com.desafioCompasso.calculadora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;
import br.com.desafioCompasso.calculadora.model.ViaAdministracaoEntity;

@Repository
public interface ViaAdministracaoRepository  extends JpaRepository<ViaAdministracaoEntity, Long> {

	Optional<ViaAdministracaoEntity> findByNome(String nome);
	
}
