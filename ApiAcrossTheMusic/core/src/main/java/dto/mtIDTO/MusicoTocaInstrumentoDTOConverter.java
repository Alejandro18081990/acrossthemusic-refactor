package dto.mtIDTO;

import entities.MusicoTocaInstrumento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicoTocaInstrumentoDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public dto.mtIDTO.MusicoTocaInstrumentoDTO convertirADTO(MusicoTocaInstrumento musicoTocaInstrumento) {
        return modelMapper.map(musicoTocaInstrumento, dto.mtIDTO.MusicoTocaInstrumentoDTO.class);
    }
}
