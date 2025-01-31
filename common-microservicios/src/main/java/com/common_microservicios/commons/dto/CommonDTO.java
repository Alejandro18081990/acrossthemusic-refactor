package com.common_microservicios.commons.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public abstract class CommonDTO<E, D> {

    private Date createAt;


    private ModelMapper modelMapper = new ModelMapper();


    public void setCreateAt() {
        this.createAt = new Date();
    }

    //Manejo de excepciones
    public void loadFromDomain(E e) {
        this.modelMapper.map(e, this);
    }
}
