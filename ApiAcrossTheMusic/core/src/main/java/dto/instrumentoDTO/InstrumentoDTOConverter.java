package dto.instrumentoDTO;


import entities.Instrumento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstrumentoDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public dto.instrumentoDTO.InstrumentoDTO convertirADTO(Instrumento instrumento) {
        return modelMapper.map(instrumento, dto.instrumentoDTO.InstrumentoDTO.class);
    }
}
