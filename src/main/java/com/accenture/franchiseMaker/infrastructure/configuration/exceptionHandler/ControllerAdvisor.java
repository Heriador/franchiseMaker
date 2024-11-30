package com.accenture.franchiseMaker.infrastructure.configuration.exceptionHandler;

import com.accenture.franchiseMaker.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleProductAlreadyExistsException(ProductAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(String.format(e.getMessage()), HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(FranchiseNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleFranchiseNotFoundException(FranchiseNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(BranchAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleBranchAlreadyExistsException(BranchAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(BranchNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBranchNotFoundException(BranchNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(FranchiseAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleFranchiseAlreadyExistsException(FranchiseAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        Map<String, Object> errors= new HashMap<>();

        e.getBindingResult().getFieldErrors()
                .forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));


        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), LocalDateTime.now()));
    }

}
