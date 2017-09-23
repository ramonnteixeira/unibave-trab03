package net.unibave.academico.trab03.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.academico.trab03.dto.ProdutoTributacaoDTO;
import net.unibave.academico.trab03.dto.TributacaoDTO;

@Api(value = "Cadastro de Tributações", tags = "tributacoes", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@Path("/tributacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TributacaoResource {

    @ApiOperation(value = "Cria uma nova tributação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tributação adicionada com sucesso", response = TributacaoDTO.class) })
    @POST
    Response inserir(@Valid final TributacaoDTO tributacao);

    @ApiOperation(value = "Lista tributações de produtos por data de vigencia e estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tributação encontradas", response = ProdutoTributacaoDTO.class, responseContainer = "List") })
    @GET
    Response buscar(
      @QueryParam("vigencia") @NotNull final String data,
      @QueryParam("estado") @NotNull final String estado
    );
    
}
