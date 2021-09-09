package br.com.desafioCompasso.calculadora.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafioCompasso.calculadora.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento,BigInteger> {

	Optional<Medicamento> findByNome(String nome);
	

	//Optional<Medicamento> findByNomeAndLaboratorioId(String nome, BigInteger laboratorio_id);
	
	
	Optional<Medicamento> findByNomeAndGrupoMedicamentoIdAndLaboratorioId(String nome,BigInteger grupo_medicamento_id , BigInteger laboratorio_id);

    
	
}