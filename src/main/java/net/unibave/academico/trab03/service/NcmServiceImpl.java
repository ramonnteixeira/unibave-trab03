package net.unibave.academico.trab03.service;

import net.unibave.academico.trab03.model.Ncm;
import net.unibave.academico.trab03.repository.NcmRepository;
import org.springframework.stereotype.Service;

@Service
public class NcmServiceImpl extends CrudServiceImpl<NcmRepository, Ncm, Long> implements NcmService {

}
