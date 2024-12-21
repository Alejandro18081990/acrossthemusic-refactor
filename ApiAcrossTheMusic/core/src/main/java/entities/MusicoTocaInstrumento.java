package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "musico_toca_instrumento")
public class MusicoTocaInstrumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musico")
    private Musico musico;

    @ManyToOne
    @JoinColumn(name = "instrumento")
    private entities.Instrumento instrumento;

}
