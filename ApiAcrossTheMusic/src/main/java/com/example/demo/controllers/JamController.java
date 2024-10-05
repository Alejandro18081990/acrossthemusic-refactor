package com.example.demo.controllers;

import com.common_microservicios.common_microservicios.commons.controller.CommonController;
import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.Musico;
import com.example.demo.services.JamSessionService;
import com.example.demo.services.impl.MusicoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("apiATM/jams")
@RequiredArgsConstructor
@Tag(name = "PI Across the music - Controlador Jams")
public class JamController extends CommonController<JamSession, JamSessionService> {


    @Autowired
    private MusicoServiceImpl musicoServiceImpl;

    @Autowired
    private MusicoDtoConverter musicoDtoConverter;


    @Operation(summary = "Devuelve todos los músicos que tocan en una jam")
    @GetMapping("/musicos/{id}")
    public ResponseEntity<List<MusicoDTO>> getMusiciansByJam(@PathVariable long id) {
        List<Musico> musicosConsultados = musicoServiceImpl.findMusicoByMusicoTocaJam(id);
        if (musicosConsultados.isEmpty())
            return ResponseEntity.notFound().build();
        List<MusicoDTO> musicosDTOsConsultados = musicosConsultados.stream().map(musico ->
                        musicoDtoConverter.convertirADTO(musico))
                .collect(Collectors.toList());
        return ResponseEntity.ok(musicosDTOsConsultados);
    }
}
