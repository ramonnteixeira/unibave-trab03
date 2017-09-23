package net.unibave.academico.trab03.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import net.unibave.academico.trab03.model.Produto;
import net.unibave.academico.trab03.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends CrudServiceImpl<ProdutoRepository, Produto, Long> implements ProdutoService {

    @Override
    public List<Produto> listar() {
        return StreamSupport
            .stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());        
    }
    
}
