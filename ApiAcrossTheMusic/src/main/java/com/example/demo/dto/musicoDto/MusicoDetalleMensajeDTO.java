package com.example.demo.dto.musicoDto;

import com.example.demo.Permisos;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class MusicoDetalleMensajeDTO {

    private long idMusico;
    private String email;

}
