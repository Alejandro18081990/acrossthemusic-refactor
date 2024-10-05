package com.example.demo.dto.musicoDto;

import java.util.List;

import com.example.demo.Permisos;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;

import com.example.demo.dto.mtj.MusicoTocaJamDTO;
import com.example.demo.entities.MusicoTocaJam;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicoDTO {

    private long idMusico;
    private String email;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private int aniosExperiencia;
    private List<MusicoTocaInstrumentoDTO> instrumentos;
    private List<MusicoTocaEstiloDTO> estilos;
    private List<MusicoTocaJamDTO> jams;
    boolean tieneFormacion;
    private String formacion;
    private Permisos permiso;
}
