package services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.MusicoTocaEstilo;

import repositorios.MusicoTocaEstiloRepository;
import services.MusicoTocaEstiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicoTocaEstiloServiceImpl extends CommonServiceImpl<MusicoTocaEstilo, MusicoTocaEstiloRepository> implements MusicoTocaEstiloService {

    @Autowired
    MusicoTocaEstiloRepository mteRepository;
}
