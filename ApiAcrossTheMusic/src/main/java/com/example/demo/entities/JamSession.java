package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JamSession")
public class JamSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJamSession;

    private String nombreJam;

    @ManyToOne
    @JoinColumn(name = "idEstilo")
    private Estilo estilo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    private String lugar;

    @OneToMany(mappedBy = "jamSession", cascade = CascadeType.ALL)
    Set<MusicoTocaJam> jamSession;

}
