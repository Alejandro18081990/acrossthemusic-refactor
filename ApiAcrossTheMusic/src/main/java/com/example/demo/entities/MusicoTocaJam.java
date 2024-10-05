package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "musico_toca_jam")
//@Table(name = "musico_toca_jam")
public class MusicoTocaJam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMusico")
    private Musico musicoTocaJam;

    @ManyToOne
    @JoinColumn(name = "idJamSession")
    private JamSession jamSession;
}
