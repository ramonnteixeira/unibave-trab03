package net.unibave.academico.trab03.resource;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import net.unibave.academico.trab03.dto.TributacaoDTO;
import net.unibave.academico.trab03.service.TributacaoService;
import org.springframework.stereotype.Component;

@Component
public class TributacaoResourceImpl implements TributacaoResource {

    @Inject
    private TributacaoService service;

    @Override
    public Response inserir(TributacaoDTO tributacao) {
        return Response.ok(new TributacaoDTO(service.inserir(tributacao.toEntity()))).build();
    }

    @Override
    public Response buscar(String data, String estado) {
        return Response.ok(service.listarProdutoTributacao(data, estado)).build();
    }
    
}
