package com.example.demo.dto.grupoDTO;


import com.common_microservicios.commons.dto.CommonDTO;
import com.example.demo.dto.musicoDto.MusicoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GrupoDTO extends CommonDTO {

    private String nombreGrupo;
    private int anioFormacion;
    private List<MusicoDTO> musicosTocanGrupo;

}
