package services.impl;



import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.Grupo;

import repositorios.GrupoRepository;

import services.GrupoService;
import org.springframework.stereotype.Service;


@Service
public class GrupoServiceImpl extends CommonServiceImpl<Grupo, GrupoRepository> implements GrupoService {


}
