package com.example.demo.dto.mtj;

import com.example.demo.dto.instrumentoDTO.InstrumentoDTOConverter;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTOConverter;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTOConverter;
import com.example.demo.dto.musicoDto.CreateMusicoDto;
import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.entities.Musico;
import com.example.demo.entities.MusicoTocaEstilo;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.entities.MusicoTocaJam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MusicoTocaJamDtoConverter {

    @Autowired
    private ModelMapper modelMapper;


    public MusicoTocaJamDTO convertirADTO(MusicoTocaJam musico) {
        return modelMapper.map(musico, MusicoTocaJamDTO.class);

    }

    public Musico convertirAMusico(CreateMusicoDto createMusicoDto) {
        return modelMapper.map(createMusicoDto, Musico.class);
    }
}
