package dto.musicoMensajeDTO;

import entities.MusicoMensaje;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MusicoMensajeDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public dto.musicoMensajeDTO.MusicoMensajeDTO convertirDto(MusicoMensaje musicoMensaje) {
        return modelMapper.map(musicoMensaje, dto.musicoMensajeDTO.MusicoMensajeDTO.class);
    }
}
