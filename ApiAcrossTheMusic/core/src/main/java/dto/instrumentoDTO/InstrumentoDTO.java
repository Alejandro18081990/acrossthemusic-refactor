package dto.instrumentoDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InstrumentoDTO extends CommonDTO {

    private long idInstrumento;
    private String nombreInstrumento;
}
