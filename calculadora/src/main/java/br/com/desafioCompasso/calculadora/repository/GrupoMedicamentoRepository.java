package br.com.desafioCompasso.calculadora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.GrupoMedicamento;

@Repository
public interface GrupoMedicamentoRepository extends JpaRepository<GrupoMedicamento,Long>{

	Optional<GrupoMedicamento> findByNome(String nome);
}
