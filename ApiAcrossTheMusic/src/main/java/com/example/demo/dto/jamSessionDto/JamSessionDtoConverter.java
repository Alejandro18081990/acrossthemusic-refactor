package com.example.demo.dto.jamSessionDto;

import com.example.demo.entities.JamSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.musicoDto.CreateMusicoDto;
import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.entities.Musico;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JamSessionDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public JamSessionDto convertirDto(JamSession jamSession) {
        return modelMapper.map(jamSession, JamSessionDto.class);
    }

    public JamSession convertirAJam(CreateJamSessionDto createJamSessionDto) {
        return modelMapper.map(createJamSessionDto, JamSession.class);
    }
}
