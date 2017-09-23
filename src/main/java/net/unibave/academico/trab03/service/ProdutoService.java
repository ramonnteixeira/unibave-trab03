package net.unibave.academico.trab03.service;

import java.util.List;
import net.unibave.academico.trab03.model.Produto;

public interface ProdutoService extends CrudService<Produto, Long>{

    List<Produto> listar();
    
}
