package com.example.demo.controllers;

import com.common_microservicios.common_microservicios.commons.controller.CommonController;

import com.example.demo.entities.Instrumento;

import com.example.demo.services.InstrumentoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("apiATM/instrumentos")
@Tag(name = "PI Across the music - Controlador instrumentos")
public class InstrumentoController extends CommonController<Instrumento, InstrumentoService> {


}
