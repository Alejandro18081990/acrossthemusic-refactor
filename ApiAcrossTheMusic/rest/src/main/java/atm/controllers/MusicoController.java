package atm.controllers;


import com.common_microservicios.commons.controller.CommonController;
import dto.musicoDto.MusicoDTO;
import entities.Musico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.impl.MusicoServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos")
@Tag(name = "PI: Across the music - Controlador Musicos")
public class MusicoController extends CommonController<Musico, MusicoDTO, services.MusicoService> {

    private static final Logger log = LoggerFactory.getLogger(MusicoController.class);

    @Autowired
    private dto.musicoDto.MusicoDtoConverter musicoDtoConverter;

    @Autowired
    private MusicoServiceImpl musicoServiceImpl;

    @Operation(summary = "Devuelve todos los musicos que tocan un instrumento y estilos determinados")
    @GetMapping("/{nombreInstrumento}/{nombreEstilo}/{aniosExperiencia}")
    public ResponseEntity<List<MusicoDTO>> getMusicoByEstiloAndInstrumento(@PathVariable String nombreInstrumento, @PathVariable String nombreEstilo, @PathVariable int aniosExperiencia) {
        List<Musico> musicos = musicoServiceImpl.findByEstiloAndInstrumento(nombreInstrumento, nombreEstilo, aniosExperiencia);
        if (musicos == null)
            ResponseEntity.notFound().build();
        List<MusicoDTO> musicosConsultaDto = new ArrayList<>();
        for (Musico musico : musicos)
            musicosConsultaDto.add(musicoDtoConverter.customLoadFromDomain(musico));
        return ResponseEntity.ok(musicosConsultaDto);
    }

    @Operation(summary = "Devuelve un musico encontrado a través de su email")
    @GetMapping("/musico/email/{email}")
    public ResponseEntity<MusicoDTO> findMusicoByEmail(@PathVariable(value = "email") String email) {
        Musico musicoConsultado = musicoServiceImpl.findMusicoByEmail(email);
        if (musicoConsultado == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musicoDtoConverter.customLoadFromDomain(musicoConsultado));
    }
}

