package com.study.demo.adapter.controller;

import com.study.demo.application.assembler.EbookAssembler;
import com.study.demo.application.dto.request.EbookAddRequest;
import com.study.demo.domain.model.EbookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/ebook")
@RestController
@RequiredArgsConstructor
public class EbookController {

    private final EbookAssembler ebookAssembler;

    @RequestMapping("/add")
    public void add(EbookAddRequest ebookAddRequest) {
        EbookEntity ebookEntity = ebookAssembler.toEntity(ebookAddRequest);
        System.out.println(ebookEntity);
    }

}
