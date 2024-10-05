package com.example.demo.services.impl;


import com.common_microservicios.common_microservicios.commons.services.impl.CommonServiceImpl;
import com.example.demo.entities.MusicoTocaJam;
import com.example.demo.repositorios.MusicoTocaJamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MusicoTocaJamServiceImpl extends CommonServiceImpl<MusicoTocaJam, MusicoTocaJamRepository> {

    @Autowired
    MusicoTocaJamRepository musicoTocaJam;

    public void deleteByMusicoAndJamSession(long idMusico, long idJamSession) {
        musicoTocaJam.deleteMusicoJam(idMusico, idJamSession);
    }

    public void deleteMusicoJamByMusicoIdMusico(Long id) {
        musicoTocaJam.deleteMusicoJamByMusicoIdMusico(id);
    }
}
