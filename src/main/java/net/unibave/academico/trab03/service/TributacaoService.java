package net.unibave.academico.trab03.service;

import java.util.List;
import net.unibave.academico.trab03.dto.ProdutoTributacaoDTO;
import net.unibave.academico.trab03.model.Tributacao;

public interface TributacaoService extends CrudService<Tributacao, Long>{
    
    List<ProdutoTributacaoDTO> listarProdutoTributacao(final String data, 
            final String estado);
    
}
