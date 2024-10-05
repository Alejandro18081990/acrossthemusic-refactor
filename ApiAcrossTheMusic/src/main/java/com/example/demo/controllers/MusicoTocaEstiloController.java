package com.example.demo.controllers;

import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTOConverter;
import com.example.demo.entities.MusicoTocaEstilo;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.repositorios.MusicoTocaEstiloRepository;
import io.micrometer.observation.annotation.Observed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos/mte")
@Tag(name = "PI: Across the music - Controlador MusicoTocaEstilo")
public class MusicoTocaEstiloController implements ControllerInterface<MusicoTocaEstilo, MusicoTocaEstiloDTO> {

    @Autowired
    MusicoTocaEstiloRepository musicoTocaEstiloRepository;

    @Autowired
    MusicoTocaEstiloDTOConverter mteDTOConverter;

    @Override
    @Operation(summary = "Devuelve todos los registros de MusicoTocaEstilo en tipo DTO")
    @GetMapping("/")
    public ResponseEntity<List<MusicoTocaEstiloDTO>> getAll() {
        List<MusicoTocaEstiloDTO> listaMTEDTO = new ArrayList<>();
        List<MusicoTocaEstilo> listaMTE = new ArrayList<>();
        listaMTE = musicoTocaEstiloRepository.findAll();
        for (MusicoTocaEstilo mte : listaMTE) {
            listaMTEDTO.add(mteDTOConverter.convertirADTO(mte));
        }
        return ResponseEntity.ok(listaMTEDTO);
    }

    @Operation(summary = "Inserta un MusicoTocaEstilo")
    @PostMapping("/")
    @Override
    public ResponseEntity<MusicoTocaEstilo> save(@RequestBody MusicoTocaEstilo musicoTocaEstilo) {
        MusicoTocaEstilo newMTI = musicoTocaEstiloRepository.save(musicoTocaEstilo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMTI);
    }

    @Override
    @Operation(summary = "Borra un registro de la tabla por su id")
    @DeleteMapping("/")
    public void delete(@PathVariable Long id) {

    }

    @Operation(summary = "Borra todos los registros de MusicoTocaEstilo que coincidan con el idMusico recibido")
    @DeleteMapping("/{idMusico}")
    public void deleteMTEByMusico(@PathVariable Long idMusico){
        System.out.println("Id ================================================ " + idMusico);
        musicoTocaEstiloRepository.deleteMusicoTocaEstiloByMusicoIdMusico(idMusico);
    }

    @Override
    public ResponseEntity<MusicoTocaEstilo> update(MusicoTocaEstilo musicoTocaInstrumento) {
        return null;
    }

    @Override
    public ResponseEntity<MusicoTocaEstiloDTO> findById(Long id) {
        return null;
    }
}
