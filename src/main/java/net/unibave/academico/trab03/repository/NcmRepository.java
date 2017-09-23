package net.unibave.academico.trab03.repository;

import net.unibave.academico.trab03.model.Ncm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NcmRepository extends PagingAndSortingRepository<Ncm, Long> {
 
}
