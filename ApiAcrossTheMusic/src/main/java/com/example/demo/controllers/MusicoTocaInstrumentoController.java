package com.example.demo.controllers;

import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTO;
import com.example.demo.dto.mtIDTO.MusicoTocaInstrumentoDTOConverter;
import com.example.demo.entities.Instrumento;
import com.example.demo.entities.Musico;
import com.example.demo.entities.MusicoTocaInstrumento;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.repositorios.MusicoTocaInstrumentoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/musicos/mti")
@Tag(name = "PI: Across the music - Controlador MusicoTocaInstrumento")
public class MusicoTocaInstrumentoController implements ControllerInterface<MusicoTocaInstrumento, MusicoTocaInstrumentoDTO> {

    @Autowired
    MusicoTocaInstrumentoRepository musicoTocaInstrumentoRepository;


    @Autowired
    MusicoTocaInstrumentoDTOConverter mtiDTOConverter;


    @Override
    @Operation(summary = "Devuelve todos los registros de MusicoTocaInstrumento")
    @GetMapping("/")
    public ResponseEntity<List<MusicoTocaInstrumentoDTO>> getAll() {
        List<MusicoTocaInstrumento> listaMTI = musicoTocaInstrumentoRepository.findAll();
        List<MusicoTocaInstrumentoDTO> listaMTIDTO = new ArrayList<>();
        for (MusicoTocaInstrumento mti : listaMTI) {
            listaMTIDTO.add(mtiDTOConverter.convertirADTO(mti));
        }
        return ResponseEntity.ok(listaMTIDTO);
    }

    @Operation(summary = "Inserta un registro en musicoTocaInstrumento")
    @PostMapping("/")
    @Override
    public ResponseEntity<MusicoTocaInstrumento> save(@RequestBody MusicoTocaInstrumento musicoTocaInstrumento) {
        System.out.println(musicoTocaInstrumento.getMusico().getEmail());
        System.out.println(musicoTocaInstrumento.getInstrumento().getNombreInstrumento());
        MusicoTocaInstrumento newMTI = musicoTocaInstrumentoRepository.save(musicoTocaInstrumento);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMTI);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @Operation(summary = "Modifica un registro de la tabla MusicoTocaInstrumento")
    @PutMapping("/")
    public ResponseEntity<MusicoTocaInstrumento> update(@RequestBody MusicoTocaInstrumento musicoTocaInstrumentoDetalle) {
        //System.out.println("====================================================Instrumento" + musicoTocaInstrumentoDetalle.getInstrumento().getNombreInstrumento());
        //  Optional<MusicoTocaInstrumento> mtiAModificar = musicoTocaInstrumentoRepository.findById(musicoTocaInstrumentoDetalle.getId());
        // if (!mtiAModificar.isPresent())
        //   return ResponseEntity.noContent().build();
        //MusicoTocaInstrumento musicoAModificar = mtiAModificar.get();
        //musicoAModificar.setInstrumento(musicoTocaInstrumentoDetalle.getInstrumento());
        return null;
    }

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

    @Override
    public ResponseEntity<MusicoTocaInstrumentoDTO> findById(Long id) {
        return null;
    }
}
