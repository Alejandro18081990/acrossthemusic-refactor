package dto.estiloDTO;

import entities.Estilo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstiloDTOConverter {


    @Autowired
    ModelMapper modelMapper;

    public dto.estiloDTO.EstiloDTO convertirADTO(Estilo estilo) {
        return modelMapper.map(estilo, dto.estiloDTO.EstiloDTO.class);
    }

    public Estilo convertirAEstilo(dto.estiloDTO.EstiloDTO estiloDTO) {
        return modelMapper.map(estiloDTO, Estilo.class);
    }
}
