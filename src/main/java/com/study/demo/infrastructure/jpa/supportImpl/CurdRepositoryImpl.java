package com.study.demo.infrastructure.jpa.supportImpl;

import com.study.demo.application.support.CurdRepository;
import com.study.demo.infrastructure.jpa.converter.BaseConverter;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public class CurdRepositoryImpl<I extends Serializable, E, P, M extends JpaRepository<P, I>,
        C extends BaseConverter<E, P>> implements CurdRepository<I, E> {

    @Resource
    private C converter;

    @Resource
    private M jpaRepository;

    @Override
    public E create(E entity) {
        return converter.toEntity(jpaRepository.save(converter.toPO(entity)));
    }
}
