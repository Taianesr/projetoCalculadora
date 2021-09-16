package br.com.desafioCompasso.calculadora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.GrupoMedicamentoEntity;

@Repository
public interface GrupoMedicamentoRepository extends JpaRepository<GrupoMedicamentoEntity,Long>{

	Optional<GrupoMedicamentoEntity> findByNome(String nome);
}
