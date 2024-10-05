package com.example.demo.entities;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "musico_toca_instrumento")
//@Table(name = "musico_toca_instrumento")
public class MusicoTocaInstrumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musico")
    private Musico musico;

    @ManyToOne
    @JoinColumn(name = "instrumento")
    private Instrumento instrumento;

}
