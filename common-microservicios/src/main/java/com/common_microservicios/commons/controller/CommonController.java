package com.common_microservicios.commons.controller;


import com.common_microservicios.commons.dto.CommonDTO;
import com.common_microservicios.commons.services.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.*;


public class CommonController<E, D extends CommonDTO, S extends CommonService<E>> {

    @Autowired
    protected S service;

    private Class<D> dtoType;

    public void init() {
        final ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        dtoType = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
    }

    @GetMapping("/")
    public ResponseEntity<List<D>> findAll() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        init();
        Iterable<E> entityList = service.findAll();
        final D dto = dtoType.getConstructor().newInstance();
        List<D> dtoList = new ArrayList<>();
        for (E entity : entityList) {
            dto.loadFromDomain(entity);
            dtoList.add(dto);
        }
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/pagina")
    public ResponseEntity<Iterable<E>> findAllByPage(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonDTO> findById(@PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        init();
        Optional<E> entityOptional = service.findById(id);
        if (entityOptional.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            final D dto = dtoType.getConstructor().newInstance();
            dto.loadFromDomain(entityOptional.get());
            return ResponseEntity.ok().body(dto);
        }

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
