package dto.estiloDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import lombok.Data;

@Data
public class EstiloDTO extends CommonDTO {

    private long idEstilo;
    private String nombreEstilo;
}
