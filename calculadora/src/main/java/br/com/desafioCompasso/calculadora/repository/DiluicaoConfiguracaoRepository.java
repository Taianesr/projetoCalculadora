package br.com.desafioCompasso.calculadora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntity;
import br.com.desafioCompasso.calculadora.model.DiluicaoConfiguracaoEntityPK;


@Repository
public interface DiluicaoConfiguracaoRepository extends JpaRepository <DiluicaoConfiguracaoEntity, DiluicaoConfiguracaoEntityPK>  {
	
	List<DiluicaoConfiguracaoEntity> findByDiluicaoConfPKMedicamentoId(Long medicamentoId);
	
	Optional <DiluicaoConfiguracaoEntity> findByDiluicaoConfPK(DiluicaoConfiguracaoEntityPK pk);

	
	//Optional <DiluicaoConfiguracaoEntity> findByDiluicaoConfPK(MedicamentoEntity med, ViaAdministracaoEntity viaAdm, int sequencia);
	
}
