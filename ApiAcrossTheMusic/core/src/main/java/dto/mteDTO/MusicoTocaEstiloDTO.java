package dto.mteDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import dto.estiloDTO.EstiloDTO;
import lombok.Data;

@Data
public class MusicoTocaEstiloDTO extends CommonDTO {

    private EstiloDTO estilo;
}
