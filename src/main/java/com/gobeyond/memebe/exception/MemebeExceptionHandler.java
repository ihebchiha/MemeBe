package com.gobeyond.memebe.exception;

import com.gobeyond.memebe.domain.dto.ErrorModel;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MemebeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { UsernameNotFoundException.class })
    public ResponseEntity<Object> handleUsernameNotFound(UsernameNotFoundException exception, RuntimeException ex,
            WebRequest request) {
        ErrorModel errorModelObject = ErrorModel.builder().statusCode(100).errorMessage(exception.getMessage()).build();
        return handleExceptionInternal(ex, errorModelObject, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
