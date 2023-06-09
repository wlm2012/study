package com.study.demo.infrastructure.jpa.po;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ebook")
public class EbookPO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "varchar(255) COMMENT '书名'")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EbookPO ebookPO = (EbookPO) o;
        return id != null && Objects.equals(id, ebookPO.id);
    }


}
