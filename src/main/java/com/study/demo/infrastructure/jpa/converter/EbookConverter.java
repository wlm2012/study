package com.study.demo.infrastructure.jpa.converter;

import com.study.demo.domain.model.EbookEntity;
import com.study.demo.infrastructure.jpa.po.EbookPO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EbookConverter implements BaseConverter<EbookEntity, EbookPO> {
}
