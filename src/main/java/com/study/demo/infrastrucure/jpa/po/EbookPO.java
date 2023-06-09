package com.study.demo.infrastrucure.jpa.po;

@Data
@Entity
@Table
public class EbookPO {

    private Long id;

    @Column()
    private String name;
}
