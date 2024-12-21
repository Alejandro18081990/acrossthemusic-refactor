package dto.mtgDTO;

import entities.MusicoTocaGrupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicoTocaGrupoDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public dto.mtgDTO.MusicoTocaGrupoDTO convertirADTO(MusicoTocaGrupo mte) {
        return modelMapper.map(mte, dto.mtgDTO.MusicoTocaGrupoDTO.class);
    }
}
