package dto.mteDTO;


import entities.MusicoTocaEstilo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicoTocaEstiloDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public dto.mteDTO.MusicoTocaEstiloDTO convertirADTO(MusicoTocaEstilo musicoTocaEstilo) {
        return modelMapper.map(musicoTocaEstilo, dto.mteDTO.MusicoTocaEstiloDTO.class);
    }
}
