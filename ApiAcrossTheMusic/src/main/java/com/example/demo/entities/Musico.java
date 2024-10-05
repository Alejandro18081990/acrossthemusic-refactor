package com.example.demo.entities;

import java.util.List;
import java.util.Set;

import com.example.demo.Permisos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "musico")
public class Musico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMusico;
    // Evita que el campo se pueda repetir
    @Column(unique = true)
    private String email;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private int aniosExperiencia;
    private String formacion;
    private boolean tieneFormacion;
    @Enumerated(EnumType.STRING)
    private Permisos permiso;

    @OneToMany(mappedBy = "musico", fetch = FetchType.EAGER)
    Set<MusicoTocaInstrumento> musicoTocaInstrumento;


    @OneToMany(mappedBy = "musico")
    Set<MusicoTocaEstilo> musicoTocaEstilo;

    @OneToMany(mappedBy = "musicoTocaJam")
    Set<MusicoTocaJam> musicoTocaJam;

    @JsonIgnore
    @OneToMany(mappedBy = "musico")
    Set<MusicoTocaGrupo> musicoTocaGrupo;

    @OneToMany(mappedBy = "musicoRemitente" )
    private Set<MusicoMensaje> musicoRemitente;

    @OneToMany(mappedBy = "musicoDestinatario")
    private Set<MusicoMensaje> musicoMensaje;
}
