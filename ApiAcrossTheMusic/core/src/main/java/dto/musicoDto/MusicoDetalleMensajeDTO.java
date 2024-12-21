package dto.musicoDto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicoDetalleMensajeDTO {

    private long idMusico;
    private String email;

}
