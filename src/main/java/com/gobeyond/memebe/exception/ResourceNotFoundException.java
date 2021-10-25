package com.gobeyond.memebe.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private int statusCode;

    public ResourceNotFoundException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

}
