package com.study.demo.domain.support;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CurdRepository<I extends Serializable, E> {

    E create(E entity);

    List<E> createAll(List<E> entities);

    Optional<E> findById(I id);

    void deleteById(I id);

}
