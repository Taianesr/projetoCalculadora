package br.com.desafioCompasso.calculadora.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.MedicamentoEntity;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity,Long> {

	Optional<MedicamentoEntity> findByNome(String nome);
	

	//Optional<Medicamento> findByNomeAndLaboratorioId(String nome, BigInteger laboratorio_id);
	
	
	Optional<MedicamentoEntity> findByNomeAndGrupoMedicamentoIdAndLaboratorioId(String nome,Long grupo_medicamento_id , Long laboratorio_id);

    
	
}
