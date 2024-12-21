package entities;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "musico")
    private Musico musico;

    @ManyToOne
    @JoinColumn(name = "estilo")
    private Estilo estilo;

}
