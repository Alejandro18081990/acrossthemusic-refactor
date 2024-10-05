package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGrupo;

    private String nombreGrupo;
    private int anioFormacion;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
    Set<MusicoTocaGrupo> musicosTocanGrupo;
}
