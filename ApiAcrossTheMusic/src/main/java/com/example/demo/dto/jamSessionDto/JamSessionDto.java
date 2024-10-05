package com.example.demo.dto.jamSessionDto;



import com.example.demo.dto.estiloDTO.EstiloDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JamSessionDto {


	private long idJamSession;

	private String nombreJam;
	
	private EstiloDTO estilo;

	private Date fecha;

	private String lugar;
}
