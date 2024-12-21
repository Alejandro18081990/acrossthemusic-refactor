package dto.musicoDto;

import java.util.List;
import entities.Permisos;
import com.common_microservicios.commons.dto.CommonDTO;

import dto.mtIDTO.MusicoTocaInstrumentoDTO;
import dto.mteDTO.MusicoTocaEstiloDTO;

import dto.mtj.MusicoTocaJamDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicoDTO extends CommonDTO {

    private long idMusico;
    private String email;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private int aniosExperiencia;
    private List<MusicoTocaInstrumentoDTO> instrumentos;
    private List<MusicoTocaEstiloDTO> estilos;
    private List<MusicoTocaJamDTO> jams;
    boolean tieneFormacion;
    private String formacion;
    private Permisos permiso;
}
