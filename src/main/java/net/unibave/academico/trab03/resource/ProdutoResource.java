package net.unibave.academico.trab03.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.academico.trab03.dto.ProdutoDTO;

@Api(value = "Cadastro de Produtos", tags = "produtos", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProdutoResource {

    @ApiOperation(value = "Cria um novo produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto adicionado com sucesso", response = ProdutoDTO.class) })
    @POST
    Response inserir(@Valid final ProdutoDTO produto);

    @ApiOperation(value = "Atualiza produto")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Produto atualizado com sucesso", response = ProdutoDTO.class),
            @ApiResponse(code = 404, message = "Produto não encontrado") })
    @PUT
    @Path(value = "{codigo}")
    Response atualizar(@PathParam(value = "codigo") final Long codigo, @Valid final ProdutoDTO produto);

    @ApiOperation(value = "Remove produto")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Produto removido com sucesso"),
            @ApiResponse(code = 404, message = "Produto não encontrado") })
    @DELETE
    @Path(value = "{codigo}")
    Response deletar(@PathParam(value = "codigo") final Long codigo);

    @ApiOperation(value = "Busca produto")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Produto retornado com sucesso", response = ProdutoDTO.class),
            @ApiResponse(code = 404, message = "Produto não encontrado") })
    @GET
    @Path(value = "{codigo}")
    Response buscar(@PathParam(value = "codigo") final Long codigo);

    @ApiOperation(value = "Lista produtos com paginação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de produtos", response = ProdutoDTO.class, responseContainer = "List") })
    @GET
    Response listar();
    
}
