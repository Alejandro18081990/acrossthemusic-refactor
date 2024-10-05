package com.example.demo.services.impl;


import com.common_microservicios.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.Grupo;

import com.example.demo.repositorios.GrupoRepository;

import com.example.demo.services.GrupoService;
import org.springframework.stereotype.Service;


@Service
public class GrupoServiceImpl extends CommonServiceImpl<Grupo, GrupoRepository> implements GrupoService {


}
