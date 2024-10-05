package com.example.demo.controllers;

import com.example.demo.dto.instrumentoDTO.InstrumentoDTO;
import com.example.demo.dto.instrumentoDTO.InstrumentoDTOConverter;
import com.example.demo.entities.Instrumento;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.services.InstrumentosServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("apiATM/instrumentos")
@Tag(name = "PI Across the music - Controlador instrumentos")
public class InstrumentoController implements ControllerInterface<Instrumento, InstrumentoDTO> {

    @Autowired
    private InstrumentosServiceImpl instrumentosServiceImpl;

    @Autowired
    private InstrumentoDTOConverter instrumentoDTOConverter;

    @Override
    @Operation(summary = "Devuelve todos los instrumentos guardados")
    @GetMapping("/")
    public ResponseEntity<List<InstrumentoDTO>> getAll() {
        List<Instrumento> instrumentos = instrumentosServiceImpl.findAll();
        if (instrumentos.isEmpty())
            return ResponseEntity.noContent().build();
        List<InstrumentoDTO> instrumentosDTOs = instrumentos
                .stream()
                .map(instrumento -> instrumentoDTOConverter.convertirADTO(instrumento))
                .collect(Collectors.toList());
        return ResponseEntity.ok(instrumentosDTOs);
    }

    @Override
    @Operation(summary = "Guarda un instrumento")
    @PostMapping("/instrumento/")
    public ResponseEntity<Instrumento> save(@RequestBody Instrumento instrumento) {
        System.out.println(instrumento.getNombreInstrumento());
        if (instrumento == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(instrumentosServiceImpl.save(instrumento));
    }

    @Override
    @Operation(summary = "Borra un instrumento encontrado por su id")
    @DeleteMapping("/instrumento/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        instrumentosServiceImpl.delete(id);
    }

    @Override
    public ResponseEntity<Instrumento> update(Instrumento instrumentoDetails) {
        return null;
    }

    @Override
    @Operation(summary = "Devuelve un instrumento de tipo DTO encontrado por su id")
    @GetMapping("/instrumento/{id}")
    public ResponseEntity<InstrumentoDTO> findById(@PathVariable(value = "id") Long id) {
        Optional<Instrumento> instrumentoConsultado = instrumentosServiceImpl.findById(id);
        if (!instrumentoConsultado.isPresent())
            return ResponseEntity.noContent().build();
        InstrumentoDTO instrumentoDTO = instrumentoDTOConverter.convertirADTO(instrumentoConsultado.get());
        return ResponseEntity.ok(instrumentoDTO);
    }
}
