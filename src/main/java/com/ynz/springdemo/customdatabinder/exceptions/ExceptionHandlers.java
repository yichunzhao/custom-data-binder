package com.ynz.springdemo.customdatabinder.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleBadRequestInput(MethodArgumentTypeMismatchException mismatchException) {
        return ResponseEntity.badRequest().body(mismatchException.getMessage());
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public ResponseEntity<String> handleMissingRequestHeaderException(ServletRequestBindingException missingRequestHeaderException) {
        return ResponseEntity.badRequest().body(missingRequestHeaderException.getMessage());
    }

}
