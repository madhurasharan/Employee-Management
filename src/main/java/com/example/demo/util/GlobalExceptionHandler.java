package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.EmployeeException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<String> handleEmployeeNotFound(EmployeeException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
}

