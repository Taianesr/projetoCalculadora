package br.com.desafioCompasso.calculadora.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;

@Repository
public interface CalculoHistoricoRepository extends JpaRepository<CalculoHistoricoEntity,Long>{
	
	//mudar query
	@Query(value = "SELECT * FROM calculo_historico c WHERE c.id >= :id BETWEEN :dataIni AND :dataFim ", nativeQuery= true)
	Optional <CalculoHistoricoEntity> findDataIniDataFim(Long id, Date dataIni, Date dataFim);
	
	Optional <CalculoHistoricoEntity> findByMedEntityNome(String nome);
	

	Optional<CalculoHistoricoEntity> findByQuantidadePrescrita(BigDecimal quantidadePrescrita);
	

}
