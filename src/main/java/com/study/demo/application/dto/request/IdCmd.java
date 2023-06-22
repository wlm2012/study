package com.study.demo.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class IdCmd {

    @NotEmpty(message = "id不能为空")
    private Long id;
}
