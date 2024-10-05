package com.example.demo.dto.grupoDTO;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.Grupo;
import com.example.demo.entities.MusicoTocaGrupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GrupoDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MusicoDtoConverter musicoDtoConverter;

    public GrupoDTO convertirADTO(Grupo grupo) {
        Set<MusicoTocaGrupo> miembros = grupo.getMusicosTocanGrupo();
        List<MusicoDTO> musicos = miembros
                .stream()
                .map(musico -> musicoDtoConverter.convertirADTO(musico.getMusico()))
                .collect(Collectors.toList());
        GrupoDTO grupoDTO = modelMapper.map(grupo, GrupoDTO.class);
        grupoDTO.setMusicosTocanGrupo(musicos);
        return grupoDTO;
    }

    public Grupo convertirAGrupo(GrupoDTO grupo) {
        return modelMapper.map(grupo, Grupo.class);
    }
}
