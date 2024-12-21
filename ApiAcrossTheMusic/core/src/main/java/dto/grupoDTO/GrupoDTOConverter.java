package dto.grupoDTO;


import dto.musicoDto.MusicoDTO;
import dto.musicoDto.MusicoDtoConverter;
import entities.Grupo;
import entities.MusicoTocaGrupo;
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

    public dto.grupoDTO.GrupoDTO convertirADTO(Grupo grupo) {
        Set<MusicoTocaGrupo> miembros = grupo.getMusicosTocanGrupo();
        List<MusicoDTO> musicos = miembros
                .stream()
                .map(musico -> musicoDtoConverter.customLoadFromDomain(musico.getMusico()))
                .collect(Collectors.toList());
        dto.grupoDTO.GrupoDTO grupoDTO = modelMapper.map(grupo, dto.grupoDTO.GrupoDTO.class);
        grupoDTO.setMusicosTocanGrupo(musicos);
        return grupoDTO;
    }

    public Grupo convertirAGrupo(dto.grupoDTO.GrupoDTO grupo) {
        return modelMapper.map(grupo, Grupo.class);
    }
}
