package com.example.securityDemo;

import com.example.securityDemo.exception.CustomArithmeticException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomArithmeticException.class)
    public String handleArithmeticException(CustomArithmeticException e) {
        System.out.println("Arithmetic error");
        return e.getMessage();
    }
}
