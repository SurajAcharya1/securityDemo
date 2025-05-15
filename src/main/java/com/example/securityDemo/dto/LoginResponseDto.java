package com.example.securityDemo.dto;

import com.example.securityDemo.RoleType;
import com.example.securityDemo.entity.User;
import com.example.securityDemo.enumerations.Gender;
import lombok.Data;

@Data
public class LoginResponseDto {
    private String accessToken;
    private String refreshToken;
    private String name;
    private String username;
    private String email;
    private RoleType roleType;
    private Gender gender;
}
