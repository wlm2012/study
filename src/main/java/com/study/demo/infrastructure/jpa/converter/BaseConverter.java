package com.study.demo.infrastructure.jpa.converter;

import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public interface BaseConverter<E, P> {

    P toPO(E entity);

    @InheritInverseConfiguration
    E toEntity(P po);


    List<P> toPO(List<E> entities);

    List<E> toEntity(List<P> pos);

}
