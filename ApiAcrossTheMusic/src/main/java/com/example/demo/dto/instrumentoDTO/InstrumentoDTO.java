package com.example.demo.dto.instrumentoDTO;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
public class InstrumentoDTO {

    private long idInstrumento;
    private String nombreInstrumento;
}
