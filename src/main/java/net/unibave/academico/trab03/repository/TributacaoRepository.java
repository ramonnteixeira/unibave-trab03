package net.unibave.academico.trab03.repository;

import java.util.List;
import net.unibave.academico.trab03.model.Tributacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TributacaoRepository extends CrudRepository<Tributacao, Long> {

    List<Tributacao> findByInicioVigenciaAndEstado(String inicioVigencia,
            String estado);
    
}
