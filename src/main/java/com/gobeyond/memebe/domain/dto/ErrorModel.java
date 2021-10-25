package com.gobeyond.memebe.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorModel {

    private Integer statusCode;
    private String errorMessage;
}
