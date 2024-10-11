package com.example.demo.services.impl;

import java.util.List;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.services.MusicoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Musico;
import com.example.demo.repositorios.MusicoRepository;

@Service
public class MusicoServiceImpl extends CommonServiceImpl<Musico, MusicoRepository> implements MusicoService {

    @Autowired
    private MusicoRepository musicoRepository;


    public List<Musico> findByEstiloAndInstrumento(String nombreInstrumento, String nombreEstilo, int aniosExperiencia) {
        return musicoRepository.findByInstrumentoAndEstilo(nombreInstrumento, nombreEstilo, aniosExperiencia);
    }

    public List<Musico> findMusicoByMusicoTocaJam(long idJam) {
        return musicoRepository.findMusicoByMusicoTocaJam(idJam);
    }

    public Musico findMusicoByEmail(String email) {
        return musicoRepository.findMusicoByEmail(email);
    }
}
