package com.example.demo.controllers;

import com.example.demo.dto.jamSessionDto.JamSessionDto;
import com.example.demo.dto.jamSessionDto.JamSessionDtoConverter;
import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.dto.musicoDto.MusicoDtoConverter;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.Musico;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.services.JamServiceImpl;
import com.example.demo.services.MusicoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("apiATM/jams")
@RequiredArgsConstructor
@Tag(name = "PI Across the music - Controlador Jams")
public class JamController implements ControllerInterface<JamSession, JamSessionDto> {

    @Autowired
    private JamServiceImpl jamServiceImpl;

    @Autowired
    private MusicoServiceImpl musicoServiceImp;

    @Autowired
    private MusicoDtoConverter musicoDtoConverter;

    @Autowired
    private JamSessionDtoConverter jamSessionDtoConverter;

    final String URL_BY_ID = "/jamSession/{id}";

    @Override
    @Operation(summary = "Devuelve todas las jams con su nombre y estilo")
    @GetMapping("/")
    public ResponseEntity<List<JamSessionDto>> getAll() {
        List<JamSession> jamSessionsConsultadas = jamServiceImpl.findAll();
        List<JamSessionDto> jamSessionsDTOsConsultadas = jamSessionsConsultadas.stream()
                .map(jam -> jamSessionDtoConverter.convertirDto(jam))
                .collect(Collectors.toList());
        return ResponseEntity.ok(jamSessionsDTOsConsultadas);
    }

    @Override
    @Operation(summary = "Guarda una jamSession")
    @PostMapping("/")
    public ResponseEntity<JamSession> save(@RequestBody JamSession jamSession) {
        System.out.println("Fecha " + jamSession.getFecha());
        return ResponseEntity.ok(jamServiceImpl.save(jamSession));
    }

    @Override
    @Operation(summary = "Devuelve una jamSession encontrada por su id")
    @GetMapping(URL_BY_ID)
    public ResponseEntity<JamSessionDto> findById(@PathVariable Long id) {
        Optional<JamSession> jamConsultada = jamServiceImpl.findById(id);
        if (!jamConsultada.isPresent())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(jamSessionDtoConverter.convertirDto(jamConsultada.get()));
    }

    @Override
    @Operation(summary = "Borra una jam encontrada por su id")
    @DeleteMapping(URL_BY_ID)
    public void delete(@PathVariable Long id) {
        jamServiceImpl.delete(id);
    }

    
    @Override
    @Operation(summary = "Modifica una jamSession encontrada por su id")
    @PutMapping(URL_BY_ID)
    public ResponseEntity<JamSession> update(@RequestBody JamSession jamDetails) {
        Optional<JamSession> jamAModificar = jamServiceImpl.findById(jamDetails.getIdJamSession());
        if (!jamAModificar.isPresent())
            return ResponseEntity.noContent().build();
        JamSession jam = jamAModificar.get();
        jam.setNombreJam(jamDetails.getNombreJam());
        jam.setEstilo(jamDetails.getEstilo());
        jam.setFecha(jamDetails.getFecha());
        jam.setLugar(jamDetails.getLugar());
        return ResponseEntity.ok(jamServiceImpl.save(jam));
    }


    @Operation(summary = "Devuelve todos los músicos que tocan en una jam")
    @GetMapping("/musicos/{id}")
    public ResponseEntity<List<MusicoDTO>> getMusiciansByJam(@PathVariable long id) {
        List<Musico> musicosConsultados = musicoServiceImp.findMusicoByMusicoTocaJam(id);
        if (musicosConsultados.isEmpty())
            return ResponseEntity.notFound().build();
        List<MusicoDTO> musicosDTOsConsultados = musicosConsultados.stream().map(musico ->
                        musicoDtoConverter.convertirADTO(musico))
                .collect(Collectors.toList());
        return ResponseEntity.ok(musicosDTOsConsultados);
    }
}
