package com.example.demo.services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.MusicoTocaEstilo;

import com.example.demo.repositorios.MusicoTocaEstiloRepository;
import com.example.demo.services.MusicoTocaEstiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicoTocaEstiloServiceImpl extends CommonServiceImpl<MusicoTocaEstilo, MusicoTocaEstiloRepository> implements MusicoTocaEstiloService {

    @Autowired
    MusicoTocaEstiloRepository mteRepository;
}
