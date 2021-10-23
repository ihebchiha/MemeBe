package com.gobeyond.memebe.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorModelObject {

    private Long statusCode;
    private String errorMessage;
}
