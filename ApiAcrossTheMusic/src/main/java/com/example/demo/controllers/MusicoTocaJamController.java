package com.example.demo.controllers;


import com.example.demo.dto.mtj.MusicoTocaJamDTO;

import com.example.demo.dto.mtj.MusicoTocaJamDtoConverter;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.Musico;
import com.example.demo.entities.MusicoTocaJam;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.services.MusicoTocaJamServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/jams/mtj")
@Tag(name = "PI: Across the music - Controlador MusicoTocaJam")
public class MusicoTocaJamController implements ControllerInterface<MusicoTocaJam, MusicoTocaJamDTO> {

    //REPASAR ==============================================================
    @Autowired
    MusicoTocaJamServiceImpl musicoTocaJamService;
    @Autowired
    MusicoTocaJamDtoConverter mtjDTOConverter;

    @Override
    @Operation(summary = "Devuelve todos los registros de MusicoTocaJam")
    @GetMapping("/")
    public ResponseEntity<List<MusicoTocaJamDTO>> getAll() {
        Iterable<MusicoTocaJam> lista = musicoTocaJamService.findAll();
        List<MusicoTocaJamDTO> listaDTO = new ArrayList<>();
        for (MusicoTocaJam mte : lista) {
            listaDTO.add(mtjDTOConverter.convertirADTO(mte));
        }
        return ResponseEntity.ok(listaDTO);
    }

    @Operation(summary = "Añade un músico a una jam session")
    @Override
    @PostMapping("/musico/")
    public ResponseEntity<MusicoTocaJam> save(@RequestBody MusicoTocaJam musicoTocaJam) {
        if (musicoTocaJam == null)
            System.out.println("Musico toca llama viene null");
        return ResponseEntity.status(HttpStatus.CREATED).body(musicoTocaJamService.save(musicoTocaJam));
    }

    @Override
    @Operation(summary = "Borra a un músico de la jam")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        musicoTocaJamService.delete(id);
    }

    @Operation(summary = "Borra a un músico de la jam")
    @DeleteMapping("/musicoJam/{idMusico}/{idJamSession}")
    public void deleteMusicoJam(@PathVariable long idMusico, @PathVariable long idJamSession) {
        musicoTocaJamService.deleteByMusicoAndJamSession(idMusico, idJamSession);
    }

    @Operation(summary = "Borra todos los registros de la tabla MusicoTocaJam mediante el id del musico recibido")
    @DeleteMapping("/musico/{id}")
    public void deleteMusicoJamByIdMusico(@PathVariable Long id) {
        musicoTocaJamService.deleteMusicoJamByMusicoIdMusico(id);
    }

    @Override
    @Operation (summary = "Modifica un registro de MusicoTocaJam TODO")
    public ResponseEntity<MusicoTocaJam> update(MusicoTocaJam musicoTocaJam) {
        return null;
    }

    @Override
    @Operation (summary = "eNCUE un registro de MusicoTocaJam TODO")
    public ResponseEntity<MusicoTocaJamDTO> findById(Long id) {
        return null;
    }
}
