package com.example.demo.services.impl;

import com.common_microservicios.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.Instrumento;

import com.example.demo.repositorios.InstrumentoRepository;

import com.example.demo.services.InstrumentoService;
import org.springframework.stereotype.Service;


@Service
public class InstrumentosServiceImpl extends CommonServiceImpl<Instrumento, InstrumentoRepository> implements InstrumentoService {


}
