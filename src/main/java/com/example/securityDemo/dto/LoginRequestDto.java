package com.example.securityDemo.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private final String username;
    private String password;
}
