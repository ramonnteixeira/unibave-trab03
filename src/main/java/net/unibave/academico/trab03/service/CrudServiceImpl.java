package net.unibave.academico.trab03.service;

import java.io.Serializable;
import java.util.Optional;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public class CrudServiceImpl<R extends CrudRepository, E, PK extends Serializable> 
  implements CrudService<E, PK> {

    @Inject
    protected R repository;
    
    @Override
    public Optional<E> buscar(PK id) {
        E entity = (E) repository.findOne(id);
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional
    public E inserir(E entity) {
        return (E) repository.save(entity);
    }

    @Override
    @Transactional
    public E atualizar(PK codigo, E entity) {
        return (E) repository.save(entity);
    }

    @Override
    @Transactional
    public void excluir(PK id) {
        buscar(id).ifPresent(repository::delete);
    }
    
}
