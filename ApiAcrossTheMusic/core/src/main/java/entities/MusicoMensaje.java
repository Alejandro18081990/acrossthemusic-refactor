package entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "musico_mensaje")
public class MusicoMensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musicoRemitente")
    private Musico musicoRemitente;

    @ManyToOne
    @JoinColumn(name = "musicoDestinatario")
    private Musico musicoDestinatario;

    private String cuerpoMensaje;

    private String fechaEnvio;

    private boolean leido;
}
