package com.example.demo.dto.musicoMensajeDTO;

import com.example.demo.dto.jamSessionDto.JamSessionDto;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.MusicoMensaje;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MusicoMensajeDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public MusicoMensajeDTO convertirDto(MusicoMensaje musicoMensaje) {
        return modelMapper.map(musicoMensaje, MusicoMensajeDTO.class);
    }
}
