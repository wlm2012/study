package com.study.demo.application.assembler;

import com.study.demo.application.dto.request.EbookCreateCmd;
import com.study.demo.application.dto.response.EbookDTO;
import com.study.demo.domain.model.EbookEntity;
import com.study.demo.util.annotation.IdIgnore;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EbookAssembler implements BaseAssembler<EbookDTO, EbookEntity> {

    @IdIgnore
    public abstract EbookEntity toEntity(EbookCreateCmd ebookCreateCmd);

    public EbookEntity toEntity(String name) {
        return EbookEntity.builder()
                .name(name)
                .build();
    }
}
