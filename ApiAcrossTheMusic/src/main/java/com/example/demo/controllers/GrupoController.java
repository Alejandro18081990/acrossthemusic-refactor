package com.example.demo.controllers;

import com.common_microservicios.common_microservicios.commons.controller.CommonController;

import com.example.demo.entities.Grupo;

import com.example.demo.services.GrupoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "PI Across the music - Controller Grupo")
@RequestMapping("apiATM/grupos")
public class GrupoController extends CommonController<Grupo, GrupoService> {


}
