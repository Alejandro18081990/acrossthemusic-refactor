package com.example.demo.services.impl;

import com.common_microservicios.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.MusicoTocaEstilo;

import com.example.demo.repositorios.MusicoTocaEstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class MusicoTocaEstiloServiceImpl extends CommonServiceImpl<MusicoTocaEstilo, MusicoTocaEstiloRepository> {

    @Autowired
    MusicoTocaEstiloRepository mteRepository;
}
