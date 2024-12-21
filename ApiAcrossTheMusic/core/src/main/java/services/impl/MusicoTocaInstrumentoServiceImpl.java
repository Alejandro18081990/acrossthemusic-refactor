package services.impl;




import com.common_microservicios.commons.services.impl.CommonServiceImpl;
import entities.MusicoTocaInstrumento;
import org.springframework.stereotype.Service;
import repositorios.MusicoTocaInstrumentoRepository;
import services.MusicoTocaInstrumentoService;


@Service
public class MusicoTocaInstrumentoServiceImpl extends CommonServiceImpl<MusicoTocaInstrumento, MusicoTocaInstrumentoRepository> implements MusicoTocaInstrumentoService {

}
