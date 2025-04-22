package com.example.securityDemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.API)
@CrossOrigin(origins = "https://demo.com, https://demo1.com", allowedHeaders = "Authorization, content-type")
public class UserController {
    static final String API = "/v1/user";

    @GetMapping("/getUser")
    @PreAuthorize("hasRole('USER')")
    @Operation(
            summary = "API for getting user data",
            security = {@SecurityRequirement(name = "bearerAuth")}
    )
    public String getUser() {
        return "user data";
    }

    @GetMapping("/getAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdmin() {
        return "admin data";
    }
}
