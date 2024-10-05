package com.example.demo.dto.mtj;

import com.example.demo.dto.instrumentoDTO.InstrumentoDTO;
import com.example.demo.dto.jamSessionDto.JamSessionDto;
import com.example.demo.dto.musicoDto.MusicoDTO;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.Musico;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MusicoTocaJamDTO {


    private MusicoDTO musico;
    private JamSessionDto jamSession;
}
