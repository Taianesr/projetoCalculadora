package br.com.desafioCompasso.calculadora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;


@Repository
public interface DiluicaoConfiguracaoRepository extends JpaRepository <DiluicaoConfiguracaoEntity, DiluicaoConfiguracaoEntityPK>  {
	
	List<DiluicaoConfiguracaoEntity> findByMedicamentoIdAndViaAdministracaoIdOrderBySequenciaAsc(Long medicamentoId, Long viaAdministracaoId);
	
	Optional<DiluicaoConfiguracaoEntity> findByMedicamentoIdAndViaAdministracaoIdAndSequencia(Long medicamentoId, Long viaAdministracaoId, int sequencia);


	void deleteByMedicamentoIdAndViaAdministracaoIdAndSequencia(Long medicamentoId, Long viaAdministracaoId, int sequencia);


	
}
