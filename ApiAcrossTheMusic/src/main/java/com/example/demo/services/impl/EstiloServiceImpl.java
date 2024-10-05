package com.example.demo.services.impl;

import com.common_microservicios.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.Estilo;
import com.example.demo.repositorios.EstiloRepository;
import com.example.demo.services.EstiloService;
import org.springframework.stereotype.Service;


@Service
public class EstiloServiceImpl extends CommonServiceImpl<Estilo, EstiloRepository> implements EstiloService {


}
