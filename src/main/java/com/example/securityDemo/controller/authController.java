package com.example.securityDemo.controller;

import com.example.securityDemo.RoleType;
import com.example.securityDemo.dto.LoginRequestDto;
import com.example.securityDemo.dto.LoginResponseDto;
import com.example.securityDemo.entity.User;
import com.example.securityDemo.record.SignInRequestRecord;
import com.example.securityDemo.security.CustomUserDetailService;
import com.example.securityDemo.security.JwtUtil;
import com.example.securityDemo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class authController {

    public final CustomUserDetailService customUserDetailService;
    public final AuthenticationManager authenticationManager;
    public final UserService userService;
    public final JwtUtil jwtUtil;

    public authController(CustomUserDetailService customUserDetailService,
                          AuthenticationManager authenticationManager, UserService userService,
                          JwtUtil jwtUtil) {
        this.customUserDetailService = customUserDetailService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInRequestRecord signInRequestRecord) {
//        System.out.println(signInRequestRecord.email().hashCode());
        User user = new User();
        user.setName(signInRequestRecord.name());
        user.setPassword(signInRequestRecord.password());
        user.setEmail(signInRequestRecord.email());
        user.setUsername(signInRequestRecord.username());
        user.setRoleType(RoleType.ADMIN);
        user.setGender(signInRequestRecord.gender());

        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                            loginRequestDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        final String accessToken = jwtUtil.generateAccessToken(loginRequestDto.getUsername());
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequestDto.getUsername());

        loginResponseDto.setAccessToken(accessToken);
        loginResponseDto.setRefreshToken(refreshToken);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
    }
}
