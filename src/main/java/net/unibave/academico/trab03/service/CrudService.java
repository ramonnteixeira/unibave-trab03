package net.unibave.academico.trab03.service;

import java.util.Optional;

public interface CrudService<E, PK> {
    
    Optional<E> buscar(PK id);
    E inserir(E entity);
    E atualizar(PK codigo, E entity);
    void excluir(PK codigo);
    
}
