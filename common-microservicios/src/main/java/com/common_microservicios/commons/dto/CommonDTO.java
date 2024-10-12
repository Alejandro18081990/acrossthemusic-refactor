package com.common_microservicios.commons.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public abstract class CommonDTO<E, D> {

    private Date createAt;

    @Autowired
    private ModelMapper modelMapper;

    public void setCreateAt() {
        this.createAt = new Date();
    }

    //Manejo de excepciones
    public void loadFromDomain(E e) {
        modelMapper.map(e, this);
    }
}
