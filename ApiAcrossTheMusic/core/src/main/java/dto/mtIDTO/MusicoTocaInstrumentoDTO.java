package dto.mtIDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import dto.instrumentoDTO.InstrumentoDTO;

import lombok.Data;

@Data
public class MusicoTocaInstrumentoDTO extends CommonDTO {

    private Long id;

    private InstrumentoDTO instrumento;
}
