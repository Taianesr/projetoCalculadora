package br.com.desafioCompasso.calculadora.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;

public interface CalculoHistoricoRepository extends JpaRepository<CalculoHistoricoEntity,Long>{
	
	@Query(value = "SELECT * FROM calculo_historico c WHERE c.id >= :id BETWEEN :dataIni AND :dataFim ", nativeQuery= true)
	Optional <CalculoHistoricoEntity> findDataIniDataFim(Long id, Date dataIni, Date dataFim);

}
