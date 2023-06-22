package com.study.demo.adapter.controller;

import com.study.demo.application.assembler.EbookAssembler;
import com.study.demo.application.dto.request.EbookCreateCmd;
import com.study.demo.application.dto.request.IdCmd;
import com.study.demo.application.dto.response.EbookDTO;
import com.study.demo.application.service.EbookServiceImpl;
import com.study.demo.domain.model.EbookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/ebook")
@RestController
@RequiredArgsConstructor
public class EbookController {

    private final EbookAssembler ebookAssembler;

    private final EbookServiceImpl ebookService;

    @PostMapping("/create")
    public void create(@RequestBody @Validated EbookCreateCmd ebookCreateCmd) {
        EbookEntity ebookEntity = ebookAssembler.toEntity(ebookCreateCmd);
        ebookService.create(ebookEntity);
    }

    @GetMapping("/{id}")
    public EbookDTO findById(@PathVariable("id") Long id) {
        EbookEntity ebookEntity = ebookService.findById(id);
        return ebookAssembler.toDTO(ebookEntity);
    }

    @PostMapping("/deleteById")
    public void deleteById(@RequestBody IdCmd idCmd) {
        ebookService.deleteById(idCmd.getId());
    }


}
