package services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.JamSession;

import repositorios.JamSessionRepository;

import services.JamSessionService;
import org.springframework.stereotype.Service;


@Service
public class JamServiceImpl extends CommonServiceImpl<JamSession, JamSessionRepository> implements JamSessionService {


}
