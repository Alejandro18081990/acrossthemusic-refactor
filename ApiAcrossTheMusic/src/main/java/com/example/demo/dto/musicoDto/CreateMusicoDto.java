package com.example.demo.dto.musicoDto;

import java.sql.Blob;

import lombok.Data;
@Data
public class CreateMusicoDto {
	private String email;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int aniosExperiencia;
	private String formacion;
	private boolean tieneFormacion;
	private Blob video;
}
