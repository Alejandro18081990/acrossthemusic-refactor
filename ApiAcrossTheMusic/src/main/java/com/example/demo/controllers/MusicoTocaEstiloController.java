package com.example.demo.controllers;

import com.common_microservicios.commons.controller.CommonController;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTO;
import com.example.demo.dto.mteDTO.MusicoTocaEstiloDTOConverter;
import com.example.demo.entities.MusicoTocaEstilo;
import com.example.demo.repositorios.MusicoTocaEstiloRepository;
import com.example.demo.services.MusicoTocaEstiloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos/mte")
@Tag(name = "PI: Across the music - Controlador MusicoTocaEstilo")
public class MusicoTocaEstiloController extends CommonController<MusicoTocaEstilo, MusicoTocaEstiloDTO,MusicoTocaEstiloService> {

    @Autowired
    MusicoTocaEstiloRepository musicoTocaEstiloRepository;

    @Autowired
    MusicoTocaEstiloDTOConverter mteDTOConverter;


    @Operation(summary = "Borra todos los registros de MusicoTocaEstilo que coincidan con el idMusico recibido")
    @DeleteMapping("/{idMusico}")
    public void deleteMTEByMusico(@PathVariable Long idMusico) {
        musicoTocaEstiloRepository.deleteMusicoTocaEstiloByMusicoIdMusico(idMusico);
    }
}
