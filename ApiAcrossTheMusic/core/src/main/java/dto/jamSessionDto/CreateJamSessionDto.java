package dto.jamSessionDto;

import entities.JamSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class CreateJamSessionDto {
	@Autowired
	private ModelMapper modelMapper;

	public dto.jamSessionDto.JamSessionDto convertirADTO(JamSession jamSession) {
		return modelMapper.map(jamSession, dto.jamSessionDto.JamSessionDto.class);
	}

	public JamSession convertirACentroSalud(CreateJamSessionDto createJamSessionDto) {
		return modelMapper.map(createJamSessionDto, JamSession.class);
	}

}
