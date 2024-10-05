package com.example.demo.dto.mteDTO;

import com.example.demo.entities.MusicoTocaEstilo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicoTocaEstiloDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public MusicoTocaEstiloDTO convertirADTO(MusicoTocaEstilo musicoTocaEstilo) {
        return modelMapper.map(musicoTocaEstilo, MusicoTocaEstiloDTO.class);
    }
}
