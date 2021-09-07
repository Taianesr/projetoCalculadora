package br.com.undefined.calculadora.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.undefined.calculadora.model.Grupo_medicamento;


public interface GrupoMedicamentoRepository extends JpaRepository<Grupo_medicamento,BigInteger>{

	Optional<Grupo_medicamento> findByNome(String nome);
}
