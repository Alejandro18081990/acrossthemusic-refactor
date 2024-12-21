package atm.controllers;


import com.common_microservicios.commons.controller.CommonController;
import entities.JamSession;
import entities.Musico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("apiATM/jams")
@RequiredArgsConstructor
@Tag(name = "PI Across the music - Controlador Jams")
public class JamController extends CommonController<JamSession, dto.jamSessionDto.JamSessionDto, services.JamSessionService> {


    @Autowired
    private services.impl.MusicoServiceImpl musicoServiceImpl;

    @Autowired
    private dto.musicoDto.MusicoDtoConverter musicoDtoConverter;


    @Operation(summary = "Devuelve todos los músicos que tocan en una jam")
    @GetMapping("/musicos/{id}")
    public ResponseEntity<List<dto.musicoDto.MusicoDTO>> getMusiciansByJam(@PathVariable long id) {
        List<Musico> musicosConsultados = musicoServiceImpl.findMusicoByMusicoTocaJam(id);
        if (musicosConsultados.isEmpty())
            return ResponseEntity.notFound().build();
        List<dto.musicoDto.MusicoDTO> musicosDTOsConsultados = musicosConsultados.stream().map(musico ->
                        musicoDtoConverter.customLoadFromDomain(musico))
                .collect(Collectors.toList());
        return ResponseEntity.ok(musicosDTOsConsultados);
    }
}
