package com.study.demo.application.service;

import com.study.demo.application.assembler.EbookAssembler;
import com.study.demo.domain.model.EbookEntity;
import com.study.demo.domain.support.EbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class EbookServiceImpl {

    private final EbookRepository ebookRepository;

    private final EbookAssembler ebookAssembler;

    public void create(EbookEntity ebookEntity) {
        ebookRepository.create(ebookEntity);
    }

    public EbookEntity findById(Long id) {
        Optional<EbookEntity> optionalEbookEntity = ebookRepository.findById(id);
        return optionalEbookEntity.orElse(null);
    }

    public void deleteById(Long id) {
        ebookRepository.deleteById(id);
    }

    @Async
    public CompletableFuture<List<EbookEntity>> createAsync(List<EbookEntity> list) {
        List<EbookEntity> entities = ebookRepository.createAll(list);
        log.info("init:{}", entities.get(entities.size() - 1).getId());
        return CompletableFuture.completedFuture(entities);
    }
}
