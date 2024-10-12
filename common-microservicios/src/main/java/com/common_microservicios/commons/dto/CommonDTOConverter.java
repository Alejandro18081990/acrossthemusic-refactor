package com.common_microservicios.commons.dto;

public interface CommonDTOConverter<E, D> {

    D customLoadFromDomain(E e);
}
