package com.example.demo.services;

import com.common_microservicios.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.JamSession;

import com.example.demo.repositorios.JamSessionRepository;

import org.springframework.stereotype.Service;


@Service
public class JamServiceImpl extends CommonServiceImpl<JamSession, JamSessionRepository> {


}
