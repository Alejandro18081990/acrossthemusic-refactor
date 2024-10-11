package com.common_microservicios.commons.controller;


import com.common_microservicios.commons.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommonController<E, S extends CommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<Iterable<E>> findAll() {
        Iterable<E> entityList = service.findAll();
        return ResponseEntity.ok().body(entityList);
    }

    @GetMapping("/pagina")
    public ResponseEntity<Iterable<E>> findAllByPage(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<E>> findById(@PathVariable Long id) {
        Optional<E> entityOptional = service.findById(id);
        if (entityOptional.isPresent())
            return ResponseEntity.ok().body(entityOptional);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<E> save(@Validated @RequestBody E entity, BindingResult result) {
        if (result.hasErrors()) {
            validation(result);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteE(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    protected ResponseEntity<Map<String, Object>> validation(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(error -> errores.put(error.getField(), "El campo " + error.getField() + "está vacío"));
        return ResponseEntity.badRequest().body(errores);
    }
}
