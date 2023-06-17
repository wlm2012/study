package com.study.demo.domain.support;

import java.io.Serializable;

public interface CurdRepository<I extends Serializable, E> {

    E create(E entity);
}
