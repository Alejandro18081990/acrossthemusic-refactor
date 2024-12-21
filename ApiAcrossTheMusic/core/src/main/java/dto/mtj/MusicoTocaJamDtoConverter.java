package dto.mtj;

import entities.Musico;
import entities.MusicoTocaJam;
import dto.musicoDto.CreateMusicoDto;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MusicoTocaJamDtoConverter {

    @Autowired
    private ModelMapper modelMapper;


    public dto.mtj.MusicoTocaJamDTO convertirADTO(MusicoTocaJam musico) {
        return modelMapper.map(musico, dto.mtj.MusicoTocaJamDTO.class);

    }

    public Musico convertirAMusico(CreateMusicoDto createMusicoDto) {
        return modelMapper.map(createMusicoDto, Musico.class);
    }
}
