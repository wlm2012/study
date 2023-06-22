package com.study.demo.infrastructure.jpa.repository;

import com.study.demo.infrastructure.jpa.po.EbookPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookJPARepository extends JpaRepository<EbookPO, Long> {
}
