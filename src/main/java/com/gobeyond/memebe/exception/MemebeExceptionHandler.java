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

        ErrorModel errorModelObject = ErrorModel
                .builder()
                .statusCode(100)
                .errorMessage(exception.getMessage()).build();

        return handleExceptionInternal(ex, errorModelObject, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<Object> handleBusinessException(BusinessException businessException, WebRequest request){
        ErrorModel errorModel = ErrorModel
                .builder()
                .statusCode(businessException.getStatusCode())
                .errorMessage(businessException.getMessage())
                .build();

        return handleExceptionInternal(businessException, errorModel, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException, WebRequest request){

        ErrorModel errorModel = ErrorModel
                .builder()
                .statusCode(400)
                .errorMessage(illegalArgumentException.getMessage())
                .build();

        return handleExceptionInternal(illegalArgumentException, errorModel, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(ResourceNotFoundException resourceNotFoundException, WebRequest request){

        ErrorModel errorModel = ErrorModel
                .builder()
                .statusCode(102)
                .errorMessage(resourceNotFoundException.getMessage())
                .build();

        return handleExceptionInternal(resourceNotFoundException, errorModel, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {FileUploadException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(FileUploadException fileUploadException, WebRequest request){

        ErrorModel errorModel = ErrorModel
                .builder()
                .statusCode(fileUploadException.statusCode)
                .errorMessage(fileUploadException.getMessage())
                .build();

        return handleExceptionInternal(fileUploadException, errorModel, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
