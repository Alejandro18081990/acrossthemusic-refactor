package dto.mtj;

import com.common_microservicios.commons.dto.CommonDTO;
import dto.jamSessionDto.JamSessionDto;
import dto.musicoDto.MusicoDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MusicoTocaJamDTO extends CommonDTO {


    private MusicoDTO musico;
    private JamSessionDto jamSession;
}
