package com.example.demo.dto.estiloDTO;

import com.example.demo.entities.Estilo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstiloDTOConverter {


    @Autowired
    ModelMapper modelMapper;

    public EstiloDTO convertirADTO(Estilo estilo) {
        return modelMapper.map(estilo, EstiloDTO.class);
    }

    public Estilo convertirAEstilo(EstiloDTO estiloDTO) {
        return modelMapper.map(estiloDTO, Estilo.class);
    }
}
