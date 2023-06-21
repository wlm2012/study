package com.study.demo.domain.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class EbookEntity {

    private Long id;

    private String name;
}
