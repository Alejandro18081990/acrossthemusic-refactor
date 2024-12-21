package services.impl;

import java.util.List;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.Musico;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import repositorios.MusicoRepository;
import services.MusicoService;


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
