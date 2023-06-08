package com.study.demo.application.assembler;

import com.study.demo.application.dto.request.EbookAddRequest;
import com.study.demo.domain.model.EbookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EbookAssembler {

    EbookEntity toEntity(EbookAddRequest ebookAddRequest);
}
