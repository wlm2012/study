package com.study.demo.application.assembler;

import com.study.demo.application.dto.request.EbookAddRequest;
import com.study.demo.domain.model.EbookEntity;
import com.study.demo.infrastructure.common.annotation.IdIgnore;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface EbookAssembler {

    @IdIgnore
    EbookEntity toEntity(EbookAddRequest ebookAddRequest);
}
