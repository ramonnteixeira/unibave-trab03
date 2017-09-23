package net.unibave.academico.trab03.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.unibave.academico.trab03.model.Ncm;

@Api(value = "Cadastro de Ncms", tags = "ncms", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@Path("/ncms")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface NcmResource {

    @ApiOperation(value = "Cria um novo ncm")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ncm adicionado com sucesso", response = Ncm.class) })
    @POST
    Response inserir(@Valid final Ncm ncm);

}
