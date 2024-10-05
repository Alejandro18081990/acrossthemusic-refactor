package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.common_microservicios.common_microservicios.commons.controller.CommonController;
import com.example.demo.services.MusicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.Musico;
import com.example.demo.repositorios.EstiloRepository;
import com.example.demo.repositorios.JamSessionRepository;
import com.example.demo.repositorios.MusicoRepository;
import com.example.demo.services.impl.MusicoServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos")
@Tag(name = "PI: Across the music - Controlador Musicos")
public class MusicoController extends CommonController<Musico, MusicoService> {

    private static final Logger log = LoggerFactory.getLogger(MusicoController.class);

    @Autowired
    private MusicoDtoConverter musicoDtoConverter;


    @Autowired
    private MusicoServiceImpl musicoServiceImpl;

    @Operation(summary = "Devuelve todos los musicos que tocan un instrumento y estilos determinados")
    @GetMapping("/{nombreInstrumento}/{nombreEstilo}/{aniosExperiencia}")
    public ResponseEntity<List<MusicoDTO>> getMusicoByEstiloAndInstrumento(@PathVariable String nombreInstrumento, @PathVariable String nombreEstilo, @PathVariable int aniosExperiencia) {
        List<Musico> musicos = musicoServiceImpl.findByEstiloAndInstrumento(nombreInstrumento, nombreEstilo, aniosExperiencia);
        if (musicos == null)
            ResponseEntity.notFound().build();
        List<MusicoDTO> musicosConsultaDto = new ArrayList<>();
        for (Musico musico : musicos)
            musicosConsultaDto.add(musicoDtoConverter.convertirADTO(musico));
        return ResponseEntity.ok(musicosConsultaDto);
    }

    @Operation(summary = "Devuelve un musico encontrado a través de su email")
    @GetMapping("/musico/email/{email}")
    public ResponseEntity<MusicoDTO> findMusicoByEmail(@PathVariable(value = "email") String email) {
        Musico musicoConsultado = musicoServiceImpl.findMusicoByEmail(email);
        if (musicoConsultado == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musicoDtoConverter.convertirADTO(musicoConsultado));
    }
}

