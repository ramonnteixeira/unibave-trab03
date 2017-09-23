package net.unibave.academico.trab03.resource;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import net.unibave.academico.trab03.model.Ncm;
import net.unibave.academico.trab03.service.NcmService;
import org.springframework.stereotype.Component;

@Component
public class NcmResourceImpl implements NcmResource {

    @Inject
    private NcmService service;
    
    @Override
    public Response inserir(Ncm ncm) {
        return Response.ok(service.inserir(ncm)).build();
    }

}
