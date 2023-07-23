package com.study.demo.infrastructure.jpa.po;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ebook")
public class EbookPO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_seq")
    @SequenceGenerator(name = "t_seq", allocationSize = 1000)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String name;


}
