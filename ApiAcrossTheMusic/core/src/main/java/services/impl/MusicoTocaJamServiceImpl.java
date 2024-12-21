package services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.MusicoTocaJam;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import repositorios.MusicoTocaJamRepository;
import services.MusicoTocaJamService;

@Service
public class MusicoTocaJamServiceImpl extends CommonServiceImpl<MusicoTocaJam, MusicoTocaJamRepository> implements MusicoTocaJamService {

    @Autowired
    MusicoTocaJamRepository musicoTocaJam;

    public void deleteByMusicoAndJamSession(long idMusico, long idJamSession) {
        musicoTocaJam.deleteMusicoJam(idMusico, idJamSession);
    }

    public void deleteMusicoJamByMusicoIdMusico(Long id) {
        musicoTocaJam.deleteMusicoJamByMusicoIdMusico(id);
    }
}
