package services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.MusicoMensaje;

import repositorios.MusicoMensajeRepository;
import services.MusicoMensajeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicoMensajeServiceImpl extends CommonServiceImpl<MusicoMensaje, MusicoMensajeRepository> implements MusicoMensajeService {

    @Autowired
    private MusicoMensajeRepository musicoMensajeRepository;


    public List<MusicoMensaje> findMusicoMensajeByMusicoDestinatario(Long id) {
        return musicoMensajeRepository.findMusicoMensajeByMusicoDestinatarioIdMusico(id);
    }

    public List<MusicoMensaje> findMusicoMensajeByMusicoRemitente(Long id) {
        return musicoMensajeRepository.findMusicoMensajeByMusicoRemitenteIdMusico(id);
    }

    public void deletMusicoMensajeByMusico(Long id) {
        musicoMensajeRepository.deleteMusicoMensajeByIdMusico(id);
    }
}
