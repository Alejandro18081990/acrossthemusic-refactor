package com.example.demo.dto.mtgDTO;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.entities.Grupo;
import com.example.demo.entities.MusicoTocaGrupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicoTocaGrupoDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public MusicoTocaGrupoDTO convertirADTO(MusicoTocaGrupo mte) {
        return modelMapper.map(mte, MusicoTocaGrupoDTO.class);
    }
}
