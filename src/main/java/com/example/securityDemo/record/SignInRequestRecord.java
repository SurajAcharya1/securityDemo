package com.example.securityDemo.record;

import com.example.securityDemo.enumerations.Gender;

public record SignInRequestRecord(
        String name,
        String password,
        String email,
        String username,
        Gender gender
) {
}
