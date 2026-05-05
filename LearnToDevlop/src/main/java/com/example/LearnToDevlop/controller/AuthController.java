package com.example.LearnToDevlop.controller;

import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.dto.AuthResponse;
import com.example.LearnToDevlop.dto.LoginRequest;
import com.example.LearnToDevlop.dto.RegisterRequest;
import com.example.LearnToDevlop.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@Valid @RequestBody RegisterRequest req) {
        return ResponseEntity.status(201).body(ApiResponse.ok(authService.register(req)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest req) {
        return ResponseEntity.ok(ApiResponse.ok("Login successful", authService.login(req)));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(
            @RequestHeader(value = "Authorization", required = false) String header) {
        return ResponseEntity.ok(ApiResponse.ok(authService.logout(header)));
    }

}