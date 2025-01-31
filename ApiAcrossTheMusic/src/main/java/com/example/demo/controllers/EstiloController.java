package com.example.demo.controllers;


import com.common_microservicios.commons.controller.CommonController;
import com.example.demo.dto.estiloDTO.EstiloDTO;
import com.example.demo.entities.Estilo;
import com.example.demo.services.EstiloService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("apiATM/estilos")
@Tag(name = "PI Across the music - Controller Estilos")
public class EstiloController extends CommonController<Estilo, EstiloDTO, EstiloService> {

}
