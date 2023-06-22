package com.study.demo.infrastructure.supportImpl;

import com.study.demo.domain.support.EbookRepository;
import com.study.demo.domain.model.EbookEntity;
import com.study.demo.infrastructure.jpa.converter.EbookConverter;
import com.study.demo.infrastructure.jpa.po.EbookPO;
import com.study.demo.infrastructure.jpa.repository.EbookJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public class EbookRepositoryImpl extends CurdRepositoryImpl<Long, EbookEntity, EbookPO, EbookJPARepository, EbookConverter> implements EbookRepository {
}
