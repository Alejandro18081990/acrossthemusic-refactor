package com.example.demo.controllers;


import com.common_microservicios.commons.controller.CommonController;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTOConverter;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.repositorios.MusicoTocaInstrumentoRepository;
import com.example.demo.services.MusicoTocaInstrumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos/mti")
@Tag(name = "PI: Across the music - Controlador MusicoTocaInstrumento")
public class MusicoTocaInstrumentoController extends CommonController<MusicoTocaInstrumento, MusicoTocaInstrumentoService> {

    //REVISAR MÉTODO VACÍO AL FINAL

    @Autowired
    MusicoTocaInstrumentoRepository musicoTocaInstrumentoRepository;

    @Autowired
    MusicoTocaInstrumentoDTOConverter mtiDTOConverter;

    @Operation(summary = "Devuelve un registro de MusicoTocaInstrumento a través de Musico y a través de Instrumento")
    @GetMapping("/{idMusico}/{idInstrumento}")
    public ResponseEntity<MusicoTocaInstrumentoDTO> findByMusicoAndInstrumento(@PathVariable Long idMusico, @PathVariable Long idInstrumento) {
        MusicoTocaInstrumento mtiConsultado = musicoTocaInstrumentoRepository.findByMusicoIdMusicoAndInstrumentoIdInstrumento(idMusico, idInstrumento);
        if (mtiConsultado == null)
            return ResponseEntity.noContent().build();
        MusicoTocaInstrumentoDTO mtiDTO = mtiDTOConverter.convertirADTO(mtiConsultado);
        return ResponseEntity.ok(mtiDTO);
    }

    @Operation(summary = "Borra los registros de MusicoTocaInstrumento que coincidan con el id del músico recibido")
    @DeleteMapping("/{idMusico}")
    public void deleteMTIbyMusico(@PathVariable Long idMusico) {
        musicoTocaInstrumentoRepository.deleteByMusicoIdMusico(idMusico);
    }

    @Operation(summary = "Borra todos los registros de la tabla MusicoTocaInstrumento mediante el id del musico recibido")
    @DeleteMapping("/musico/{id}")
    public void deleteMusicoJamByIdMusico(@PathVariable Long id) {

    }
}
