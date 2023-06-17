package com.study.demo.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EbookCreateCmd {

    @NotEmpty(message = "书名不能为空")
    private String name;
}
