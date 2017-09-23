package net.unibave.academico.trab03.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.unibave.academico.trab03.model.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

}
