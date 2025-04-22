package com.example.securityDemo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e) {
        System.out.println("Arithmetic error");
        return e.getMessage();
    }
}
