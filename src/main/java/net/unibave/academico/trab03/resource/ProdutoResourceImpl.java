package net.unibave.academico.trab03.resource;

import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import net.unibave.academico.trab03.dto.ProdutoDTO;
import net.unibave.academico.trab03.service.ProdutoService;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResourceImpl implements ProdutoResource {

    @Inject
    private ProdutoService service;
    
    @Override
    public Response inserir(ProdutoDTO produto) {
        return Response.ok(new ProdutoDTO(service.inserir(produto.toEntity()))).build();
    }

    @Override
    public Response atualizar(Long codigo, ProdutoDTO produto) {
        return Response.ok(new ProdutoDTO(service.atualizar(codigo, produto.toEntity()))).build();
    }

    @Override
    public Response deletar(Long codigo) {
        service.excluir(codigo);
        return Response.noContent().build();
    }

    @Override
    public Response buscar(Long codigo) {
        return Response.ok(new ProdutoDTO(service.buscar(codigo).get())).build();
    }

    @Override
    public Response listar() {
        return Response.ok(service.listar().stream().map(ProdutoDTO::new)
                .collect(Collectors.toList())).build();
    }

}
