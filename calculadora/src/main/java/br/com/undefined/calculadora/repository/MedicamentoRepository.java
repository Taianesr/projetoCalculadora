package br.com.undefined.calculadora.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.undefined.calculadora.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento,BigInteger> {

	Optional<Medicamento> findByNome(String nome);
	
    
	
}
