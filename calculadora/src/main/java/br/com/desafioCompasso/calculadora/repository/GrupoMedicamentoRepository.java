package br.com.desafioCompasso.calculadora.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafioCompasso.calculadora.model.GrupoMedicamento;


public interface GrupoMedicamentoRepository extends JpaRepository<GrupoMedicamento,BigInteger>{

	Optional<GrupoMedicamento> findByNome(String nome);
}
