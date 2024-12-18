package com.example.demo.dto.mtIDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import com.example.demo.dto.instrumentoDTO.InstrumentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MusicoTocaInstrumentoDTO extends CommonDTO {

    private Long id;

    private InstrumentoDTO instrumento;
}
