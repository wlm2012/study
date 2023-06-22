package com.study.demo.domain.support;

import java.io.Serializable;
import java.util.Optional;

public interface CurdRepository<I extends Serializable, E> {

    E create(E entity);

    Optional<E> findById(I id);

    void deleteById(I id);

}
