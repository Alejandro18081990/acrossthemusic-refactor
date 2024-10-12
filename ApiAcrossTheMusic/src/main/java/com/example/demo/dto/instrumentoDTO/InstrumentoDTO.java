package com.example.demo.dto.instrumentoDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
public class InstrumentoDTO extends CommonDTO {

    private long idInstrumento;
    private String nombreInstrumento;
}
