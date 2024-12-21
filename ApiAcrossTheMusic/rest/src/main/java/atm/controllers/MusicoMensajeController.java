package atm.controllers;

import com.common_microservicios.commons.controller.CommonController;

import dto.musicoMensajeDTO.MusicoMensajeDTO;
import dto.musicoMensajeDTO.MusicoMensajeDTOConverter;
import entities.MusicoMensaje;
import services.MusicoMensajeService;
import services.impl.MusicoMensajeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicoMensaje")
@Tag(name = "PI: Across the music - Controlador MusicoMensaje")
public class MusicoMensajeController extends CommonController<MusicoMensaje, dto.musicoMensajeDTO.MusicoMensajeDTO, MusicoMensajeService> {


    @Autowired
    private final MusicoMensajeServiceImpl musicoMensajeServiceImpl;
    @Autowired
    private MusicoMensajeDTOConverter musicoMensajeDTOConverter;

    @Operation(summary = "Borra todos los registros que coincidan con el id musico recibido")
    @DeleteMapping("/musico/{id}")
    public void deleteMusicoMensajeByMusico(@PathVariable Long id) {
        musicoMensajeServiceImpl.deletMusicoMensajeByMusico(id);
    }


    @GetMapping("/musico/{id}")
    @Operation(summary = "Devuelve todos los registros de MusicoMensaje que coinciden con la idMusico recibida")
    public ResponseEntity<List<MusicoMensajeDTO>> findMusicoMensajeByMusicoDestinatarioId(@PathVariable Long id) {
        if (id == null || id < 0)
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
        if (id == null || id < 0)
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

