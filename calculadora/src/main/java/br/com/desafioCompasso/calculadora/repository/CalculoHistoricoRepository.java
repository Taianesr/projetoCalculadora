package br.com.desafioCompasso.calculadora.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.CalculoHistoricoEntity;

@Repository
public interface CalculoHistoricoRepository extends JpaRepository<CalculoHistoricoEntity,Long>{

	
	Optional <CalculoHistoricoEntity> findByMedEntityNome(String nome);
	

	Optional<CalculoHistoricoEntity> findByQuantidadePrescrita(BigDecimal quantidadePrescrita);
	
	 List<CalculoHistoricoEntity> findAllByDataCalculoBetween(Date dataIni, Date dataFim);

}
