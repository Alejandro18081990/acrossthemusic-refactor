package entities;


import com.common_microservicios.commons.entity.CommonEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "musico")
public class Musico extends CommonEntity {

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

    @OneToMany(mappedBy = "musicoRemitente")
    private Set<MusicoMensaje> musicoRemitente;

    @OneToMany(mappedBy = "musicoDestinatario")
    private Set<MusicoMensaje> musicoMensaje;
}
