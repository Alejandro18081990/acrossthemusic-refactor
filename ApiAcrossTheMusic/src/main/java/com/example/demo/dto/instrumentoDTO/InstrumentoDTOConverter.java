package com.example.demo.dto.instrumentoDTO;

import com.example.demo.entities.Instrumento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstrumentoDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public InstrumentoDTO convertirADTO(Instrumento instrumento) {
        return modelMapper.map(instrumento, InstrumentoDTO.class);
    }
}
