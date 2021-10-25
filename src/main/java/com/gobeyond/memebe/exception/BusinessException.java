package com.gobeyond.memebe.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private Integer statusCode;

    public BusinessException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

}
