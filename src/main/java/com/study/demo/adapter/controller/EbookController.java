package com.study.demo.adapter.controller;

import com.github.javafaker.Faker;
import com.study.demo.application.assembler.EbookAssembler;
import com.study.demo.application.dto.request.EbookCreateCmd;
import com.study.demo.application.dto.request.IdCmd;
import com.study.demo.application.dto.response.EbookDTO;
import com.study.demo.application.service.EbookServiceImpl;
import com.study.demo.domain.model.EbookEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
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
    public void deleteById(@RequestBody @Validated IdCmd idCmd) {
        ebookService.deleteById(idCmd.getId());
    }


    @PostMapping("/createAsync")
    public void createAsync(int num) {

        long start = System.currentTimeMillis();
        List<List<EbookEntity>> lists = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < num; i++) {
            List<EbookEntity> ebookEntities = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                ebookEntities.add(ebookAssembler.toEntity(faker.name().name()));
            }
            lists.add(ebookEntities);
        }
        log.info("生成执行时长：{}毫秒", System.currentTimeMillis() - start);

        List<CompletableFuture<List<EbookEntity>>> completableFutures = new ArrayList<>();
        for (List<EbookEntity> list : lists) {
            CompletableFuture<List<EbookEntity>> completableFuture = ebookService.createAsync(list);
            completableFutures.add(completableFuture);
        }
        log.info("异步执行时长：{}毫秒", System.currentTimeMillis() - start);
        CompletableFuture<Void> future = CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new));
        log.info("异步allOf执行时长：{}毫秒", System.currentTimeMillis() - start);
        future.join();
        log.info("异步结果执行时长：{}毫秒", System.currentTimeMillis() - start);
        for (CompletableFuture<List<EbookEntity>> completableFuture : completableFutures) {
            try {
                List<EbookEntity> ebookEntities = completableFuture.get();
                log.info("size:{}", ebookEntities.size());
                log.info("1000:{}", ebookEntities.get(999).getId());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("总执行时长：{}毫秒", System.currentTimeMillis() - start);
    }


}
