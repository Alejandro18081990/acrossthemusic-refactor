package com.example.demo.controllers;

import com.example.demo.dto.grupoDTO.GrupoDTO;
import com.example.demo.dto.grupoDTO.GrupoDTOConverter;
import com.example.demo.entities.Grupo;
import com.example.demo.interfaces.ControllerInterface;
import com.example.demo.services.GrupoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Tag(name = "PI Across the music - Controller Grupo")
@RequestMapping("apiATM/grupos")
public class GrupoController implements ControllerInterface<Grupo, GrupoDTO> {

    private final String ENDPOINT_BY_ID = "/grupo/{id}";

    @Autowired
    private GrupoServiceImpl grupoServiceImpl;

    @Autowired
    private GrupoDTOConverter grupoDTOConverter;


    @Override
    @Operation(summary = "Devuelve todos los grupo tipo DTO")
    @GetMapping("/")
    public ResponseEntity<List<GrupoDTO>> getAll() {
        List<Grupo> gruposConsultados = grupoServiceImpl.findAll();
        if (gruposConsultados.isEmpty())
            return ResponseEntity.noContent().build();
        List<GrupoDTO> gruposDTO = gruposConsultados
                .stream()
                .map(grupo -> grupoDTOConverter.convertirADTO(grupo))
                .collect(Collectors.toList());

        return ResponseEntity.ok(gruposDTO);
    }

    @Override
    @Operation(summary = "Guarda un grupo en la base de datos")
    @PostMapping("/")
    public ResponseEntity<Grupo> save(Grupo grupo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(grupo);
    }


    @Override
    @Operation(summary = "Borra un grupo encontrado por su id")
    @DeleteMapping(ENDPOINT_BY_ID)
    public void delete(Long id) {
        grupoServiceImpl.delete(id);
    }

    @Override
    @Operation(summary = "Modifica un grupo encontrado por su id")
    @PutMapping(ENDPOINT_BY_ID)
    public ResponseEntity<Grupo> update(Grupo grupoDetails) {
        Optional<Grupo> grupoAModifiar = grupoServiceImpl.findById(grupoDetails.getIdGrupo());
        if (!grupoAModifiar.isPresent())
            return ResponseEntity.noContent().build();
        Grupo grupo = grupoAModifiar.get();
        grupo.setNombreGrupo(grupoDetails.getNombreGrupo());
        grupo.setAnioFormacion(grupoDetails.getAnioFormacion());
        return ResponseEntity.ok(grupoServiceImpl.save(grupo));
    }


    @Override
    @Operation(summary = "Devuelve un grupo encontrado por su id")
    @GetMapping(ENDPOINT_BY_ID)
    public ResponseEntity<GrupoDTO> findById(@PathVariable Long id) {
        Optional<Grupo> grupoConsultado = grupoServiceImpl.findById(id);
        if (!grupoConsultado.isPresent())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(grupoDTOConverter.convertirADTO(grupoConsultado.get()));
    }
}
