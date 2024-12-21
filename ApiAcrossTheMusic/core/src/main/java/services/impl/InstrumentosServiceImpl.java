package services.impl;



import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.Instrumento;

import repositorios.InstrumentoRepository;

import services.InstrumentoService;
import org.springframework.stereotype.Service;


@Service
public class InstrumentosServiceImpl extends CommonServiceImpl<Instrumento, InstrumentoRepository> implements InstrumentoService {


}
