package com.example.demo.dto.mtIDTO;

import com.example.demo.entities.MusicoTocaInstrumento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicoTocaInstrumentoDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public MusicoTocaInstrumentoDTO convertirADTO(MusicoTocaInstrumento musicoTocaInstrumento) {
        return modelMapper.map(musicoTocaInstrumento, MusicoTocaInstrumentoDTO.class);
    }
}
