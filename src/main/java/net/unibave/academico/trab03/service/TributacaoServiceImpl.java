package net.unibave.academico.trab03.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import net.unibave.academico.trab03.dto.ProdutoTributacaoDTO;
import net.unibave.academico.trab03.model.Tributacao;
import net.unibave.academico.trab03.repository.TributacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class TributacaoServiceImpl extends CrudServiceImpl<TributacaoRepository, Tributacao, Long> 
  implements TributacaoService {

    @Override
    @Transactional
    public List<ProdutoTributacaoDTO> listarProdutoTributacao(String data, String estado) {
        List<Tributacao> tributacoes = repository.findByInicioVigenciaAndEstado(data, estado);
        List<ProdutoTributacaoDTO> retorno = new ArrayList<>();
        tributacoes.stream().forEach(entity -> mapToDto(entity, retorno));
        return retorno;
    }
    
    private void mapToDto(Tributacao entity, List<ProdutoTributacaoDTO> retorno) {
        entity.getNcm().getProdutos().forEach(produto -> {
            ProdutoTributacaoDTO dto = new ProdutoTributacaoDTO();
            dto.setCodigoBarra(produto.getCodigoBarras());
            dto.setCodigoNcm(entity.getNcm().getCodigo());
            dto.setPercentualICMS(entity.getPercentualIcms());
            retorno.add(dto);
        });        
    }

}
