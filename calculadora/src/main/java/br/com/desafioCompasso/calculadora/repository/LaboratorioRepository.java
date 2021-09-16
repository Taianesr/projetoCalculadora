package br.com.desafioCompasso.calculadora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.LaboratorioEntity;

@Repository
public interface LaboratorioRepository extends JpaRepository<LaboratorioEntity, Long> {
	
	Optional<LaboratorioEntity> findByNome(String nome);
	

}
