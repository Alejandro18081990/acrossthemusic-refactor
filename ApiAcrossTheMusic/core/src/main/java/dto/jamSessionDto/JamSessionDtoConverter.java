package dto.jamSessionDto;

import entities.JamSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JamSessionDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public dto.jamSessionDto.JamSessionDto convertirDto(JamSession jamSession) {
        return modelMapper.map(jamSession, dto.jamSessionDto.JamSessionDto.class);
    }

    public JamSession convertirAJam(CreateJamSessionDto createJamSessionDto) {
        return modelMapper.map(createJamSessionDto, JamSession.class);
    }
}
