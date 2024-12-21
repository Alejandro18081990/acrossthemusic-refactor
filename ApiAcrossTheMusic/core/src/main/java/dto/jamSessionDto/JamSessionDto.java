package dto.jamSessionDto;



import com.common_microservicios.commons.dto.CommonDTO;
import dto.estiloDTO.EstiloDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JamSessionDto extends CommonDTO {


	private long idJamSession;

	private String nombreJam;
	
	private EstiloDTO estilo;

	private Date fecha;

	private String lugar;
}
