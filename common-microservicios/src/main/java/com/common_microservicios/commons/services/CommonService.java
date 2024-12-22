package com.common_microservicios.commons.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
public interface CommonService<E>{

    public Iterable<E> findAll();

    public Page<E> findAll(Pageable pageable);

    public Optional<E> findById(Long id);

    public E save (E entity);

    public void deleteById (Long id);
}
