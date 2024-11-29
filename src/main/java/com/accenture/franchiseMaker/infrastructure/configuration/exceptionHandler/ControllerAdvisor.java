package com.accenture.franchiseMaker.infrastructure.configuration.exceptionHandler;

import com.accenture.franchiseMaker.domain.exceptions.ProductAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleProductAlreadyExistsException(ProductAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(String.format(e.getMessage()), HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), LocalDateTime.now()));
    }

}
