package com.study.demo.application.support;

import java.io.Serializable;

public interface CurdRepository<I extends Serializable, E> {

    E create(E entity);
}
