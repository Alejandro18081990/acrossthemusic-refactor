package dto.musicoMensajeDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import dto.musicoDto.MusicoDetalleMensajeDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public class MusicoMensajeDTO extends CommonDTO {

    private Long id;
    private MusicoDetalleMensajeDTO musicoRemitente;
    private MusicoDetalleMensajeDTO musicoDestinatario;
    private String cuerpoMensaje;
    private String fechaEnvio ;
    private boolean leido;
}
