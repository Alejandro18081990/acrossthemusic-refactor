package com.example.demo.dto.musicoMensajeDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import com.example.demo.dto.musicoDto.MusicoDetalleMensajeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
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
