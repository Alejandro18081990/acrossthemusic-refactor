package com.example.demo.dto.musicoDto;

import com.example.demo.dto.instrumentoDTO.InstrumentoDTOConverter;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTOConverter;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTOConverter;
import com.example.demo.dto.mtj.MusicoTocaJamDTO;
import com.example.demo.dto.mtj.MusicoTocaJamDtoConverter;
import com.example.demo.entities.MusicoTocaEstilo;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.entities.MusicoTocaJam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Musico;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MusicoDtoConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    InstrumentoDTOConverter instrumentoDTOConverter;
    @Autowired
    MusicoTocaInstrumentoDTOConverter musicoTocaInstrumentoDTOConverter;
    @Autowired
    MusicoTocaEstiloDTOConverter musicoTocaEstiloDTOConverter;
    @Autowired
    MusicoTocaJamDtoConverter musicoTocaJamDTOConverter;

    public MusicoDTO convertirADTO(Musico musico) {
        MusicoDTO musicoDTO = modelMapper.map(musico, MusicoDTO.class);
        List<MusicoTocaInstrumentoDTO> listaInstrumentosDTO = new ArrayList<>();
        List<MusicoTocaEstiloDTO> listaEstilosDTO = new ArrayList<>();
        List<MusicoTocaJamDTO> listaJamDTO = new ArrayList<>();
        for (MusicoTocaInstrumento instrumento : musico.getMusicoTocaInstrumento())
            listaInstrumentosDTO.add(musicoTocaInstrumentoDTOConverter.convertirADTO(instrumento));

        for (MusicoTocaEstilo estilo : musico.getMusicoTocaEstilo()) {
            listaEstilosDTO.add(musicoTocaEstiloDTOConverter.convertirADTO(estilo));
        }

        for (MusicoTocaJam jam : musico.getMusicoTocaJam())
            listaJamDTO.add(musicoTocaJamDTOConverter.convertirADTO(jam));

        musicoDTO.setInstrumentos(listaInstrumentosDTO);
        musicoDTO.setEstilos(listaEstilosDTO);
        musicoDTO.setJams(listaJamDTO);
        return musicoDTO;
    }

    public Musico convertirAMusico(CreateMusicoDto createMusicoDto) {
        return modelMapper.map(createMusicoDto, Musico.class);
    }
}
