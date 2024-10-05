package com.example.demo.dto.mtIDTO;

import com.example.demo.dto.instrumentoDTO.InstrumentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MusicoTocaInstrumentoDTO {

    Long id;

    private InstrumentoDTO instrumento;
}
