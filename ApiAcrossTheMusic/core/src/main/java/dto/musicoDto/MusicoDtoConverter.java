package dto.musicoDto;


import com.common_microservicios.commons.dto.CommonDTO;
import com.common_microservicios.commons.dto.CommonDTOConverter;
import dto.mtIDTO.MusicoTocaInstrumentoDTOConverter;
import dto.mteDTO.MusicoTocaEstiloDTOConverter;
import dto.mtj.MusicoTocaJamDtoConverter;
import entities.Musico;
import entities.MusicoTocaEstilo;
import entities.MusicoTocaInstrumento;
import entities.MusicoTocaJam;
import dto.instrumentoDTO.InstrumentoDTOConverter;
import dto.mtIDTO.MusicoTocaInstrumentoDTO;

import dto.mteDTO.MusicoTocaEstiloDTO;

import dto.mtj.MusicoTocaJamDTO;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MusicoDtoConverter extends CommonDTO<Musico, MusicoDTO> implements CommonDTOConverter<Musico, MusicoDTO> {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    InstrumentoDTOConverter instrumentoDTOConverter;
    @Autowired
    MusicoTocaInstrumentoDTOConverter musicoTocaInstrumentoDTOConverter;
    @Autowired
    MusicoTocaEstiloDTOConverter musicoTocaEstiloDTOConverter;
    @Autowired
    MusicoTocaJamDtoConverter musicoTocaJamDTOConverter;

    @Override
    public MusicoDTO customLoadFromDomain(Musico musico) {
        MusicoDTO musicoDTO = modelMapper.map(musico, MusicoDTO.class);
        List<MusicoTocaInstrumentoDTO> listaInstrumentosDTO = new ArrayList<>();
        List<MusicoTocaEstiloDTO> listaEstilosDTO = new ArrayList<>();
        List<MusicoTocaJamDTO> listaJamDTO = new ArrayList<>();

        for (MusicoTocaInstrumento instrumento : musico.getMusicoTocaInstrumento())
            listaInstrumentosDTO.add(musicoTocaInstrumentoDTOConverter.convertirADTO(instrumento));

        for (MusicoTocaEstilo estilo : musico.getMusicoTocaEstilo()) {
            listaEstilosDTO.add(musicoTocaEstiloDTOConverter.convertirADTO(estilo));
        }

        for (MusicoTocaJam jam : musico.getMusicoTocaJam())
            listaJamDTO.add(musicoTocaJamDTOConverter.convertirADTO(jam));

        musicoDTO.setInstrumentos(listaInstrumentosDTO);
        musicoDTO.setEstilos(listaEstilosDTO);
        musicoDTO.setJams(listaJamDTO);
        return musicoDTO;
    }

    public Musico convertirAMusico(dto.musicoDto.CreateMusicoDto createMusicoDto) {
        return modelMapper.map(createMusicoDto, Musico.class);
    }
}
