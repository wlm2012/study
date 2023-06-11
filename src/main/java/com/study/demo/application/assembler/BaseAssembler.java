package com.study.demo.application.assembler;

import java.util.List;

public interface BaseAssembler<D, E> {
    D toDTO(E entity);

    List<D> toDTO(List<E> entities);
}
