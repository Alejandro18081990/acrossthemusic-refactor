package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "musico_toca_estilo")
public class MusicoTocaEstilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "musico")
    private Musico musico;

    @ManyToOne
    @JoinColumn(name = "estilo")
    private Estilo estilo;

}
