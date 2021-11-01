package com.gobeyond.memebe.exception;

import lombok.Getter;

@Getter
public class FileUploadException extends RuntimeException{
    int statusCode;

    public FileUploadException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
