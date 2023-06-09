package com.study.demo.infrastructure.jpa.converter;

import java.util.List;

public interface BaseConverter<E, P> {

    P toPO(E entity);

    @InheritInverseConfiguration
    E toEntity(P po);


    List<P> toPO(List<E> entities);

    List<E> toEntity(List<P> pos);

}
