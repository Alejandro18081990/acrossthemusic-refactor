package com.example.demo.controllers;

import com.example.demo.dto.musicoMensajeDTO.MusicoMensajeDTO;
import com.example.demo.dto.musicoMensajeDTO.MusicoMensajeDTOConverter;
import com.example.demo.entities.MusicoMensaje;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.services.MusicoMensajeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicoMensaje")
@Tag(name = "PI: Across the music - Controlador MusicoMensaje")
public class MusicoMensajeController implements ControllerInterface<MusicoMensaje, MusicoMensajeDTO> {

    private static final Logger log = LoggerFactory.getLogger(MusicoMensajeController.class);
    @Autowired
    private final MusicoMensajeServiceImpl musicoMensajeServiceImpl;
    @Autowired
    private MusicoMensajeDTOConverter musicoMensajeDTOConverter;


    final String URL_BY_ID = "musicoMensaje/{id}";

    @Override
    @Operation(summary = "Devuelve todos los registros de MusicoMensaje")
    @GetMapping("/")
    public ResponseEntity<List<MusicoMensajeDTO>> getAll() {
        Iterable<MusicoMensaje> listaMusicoMensaje = musicoMensajeServiceImpl.findAll();
        List<MusicoMensajeDTO> listaMusicoMensajeDTO = new ArrayList<>();
        for (MusicoMensaje mm : listaMusicoMensaje)
            listaMusicoMensajeDTO.add(musicoMensajeDTOConverter.convertirDto(mm));
        return ResponseEntity.ok(listaMusicoMensajeDTO);
    }

    @Override
    @Operation(summary = "Guarda un registro en MusicoMensaje")
    @PostMapping("/mensaje")
    public ResponseEntity<MusicoMensaje> save(@RequestBody MusicoMensaje musicoMensaje) {
        if (musicoMensaje == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musicoMensajeServiceImpl.save(musicoMensaje));
    }

    @Override
    @Operation(summary = "Borra un mensaje por su id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        musicoMensajeServiceImpl.delete(id);
    }


    @Operation(summary = "Borra todos los registros que coincidan con el id musico recibido")
    @DeleteMapping("/musico/{id}")
    public void deleteMusicoMensajeByMusico(@PathVariable Long id) {
        musicoMensajeServiceImpl.deletMusicoMensajeByMusico(id);
    }

    @Override
    @PutMapping("mensajeMod/")
    public ResponseEntity<MusicoMensaje> update(@RequestBody MusicoMensaje musicoMensaje) {
        MusicoMensaje mm = musicoMensajeServiceImpl.findById(musicoMensaje.getId()).get();
        mm.setLeido(musicoMensaje.isLeido());
        return ResponseEntity.ok(musicoMensajeServiceImpl.save(mm));
    }

    @Override
    public ResponseEntity<MusicoMensajeDTO> findById(Long id) {
        return null;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Devuelve todos los registros de MusicoMensaje que coinciden con la idMusico recibida")
    public ResponseEntity<List<MusicoMensajeDTO>> findMusicoMensajeByMusicoDestinatarioId(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.noContent().build();
        List<MusicoMensaje> misMensajes = musicoMensajeServiceImpl.findMusicoMensajeByMusicoDestinatario(id);
        List<MusicoMensajeDTO> misMensajesDTO = new ArrayList<>();
        for (MusicoMensaje mm : misMensajes) {
            MusicoMensajeDTO mmDTO = musicoMensajeDTOConverter.convertirDto(mm);
            misMensajesDTO.add(mmDTO);
        }
        return ResponseEntity.ok(misMensajesDTO);
    }

    @GetMapping("enviado/{id}")
    @Operation(summary = "Devuelve todos los registros de MusicoMensaje que coinciden con la idMusico recibida")
    public ResponseEntity<List<MusicoMensajeDTO>> findMusicoMensajeByMusicoRemitenteIdMusico(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.noContent().build();
        List<MusicoMensaje> misMensajes = musicoMensajeServiceImpl.findMusicoMensajeByMusicoRemitente(id);
        List<MusicoMensajeDTO> misMensajesDTO = new ArrayList<>();

        for (MusicoMensaje mm : misMensajes) {
            MusicoMensajeDTO mmDTO = musicoMensajeDTOConverter.convertirDto(mm);
            misMensajesDTO.add(mmDTO);
        }
        return ResponseEntity.ok(misMensajesDTO);
    }
}

