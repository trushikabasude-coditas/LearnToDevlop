package com.example.LearnToDevlop.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
    public GlobalExceptionHandler(String message){
        @ExceptionHandler

    }
}
