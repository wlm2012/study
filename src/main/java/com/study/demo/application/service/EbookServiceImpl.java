package com.study.demo.application.service;

import com.study.demo.domain.model.EbookEntity;
import com.study.demo.domain.support.EbookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EbookServiceImpl {

    private final EbookRepository ebookRepository;

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
}
