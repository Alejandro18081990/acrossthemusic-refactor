package com.example.demo.services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.JamSession;

import com.example.demo.repositorios.JamSessionRepository;

import com.example.demo.services.JamSessionService;
import org.springframework.stereotype.Service;


@Service
public class JamServiceImpl extends CommonServiceImpl<JamSession, JamSessionRepository> implements JamSessionService {


}
