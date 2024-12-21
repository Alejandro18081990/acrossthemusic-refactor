package services.impl;


import com.common_microservicios.commons.services.impl.CommonServiceImpl;

import entities.Estilo;
import org.springframework.stereotype.Service;
import repositorios.EstiloRepository;
import services.EstiloService;


@Service
public class EstiloServiceImpl extends CommonServiceImpl<Estilo, EstiloRepository> implements EstiloService {


}
