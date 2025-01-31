package com.example.demo.services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.MusicoTocaInstrumento;

import com.example.demo.repositorios.MusicoTocaInstrumentoRepository;

import com.example.demo.services.MusicoTocaInstrumentoService;
import org.springframework.stereotype.Service;


@Service
public class MusicoTocaInstrumentoServiceImpl extends CommonServiceImpl<MusicoTocaInstrumento, MusicoTocaInstrumentoRepository> implements MusicoTocaInstrumentoService {

}
