package com.example.LearnToDevlop.service;

import com.example.LearnToDevlop.dto.AuthResponse;
import com.example.LearnToDevlop.dto.LoginRequest;
import com.example.LearnToDevlop.dto.RegisterRequest;
import com.example.LearnToDevlop.entity.Role;
import com.example.LearnToDevlop.entity.User;
import com.example.LearnToDevlop.repository.UserRepository;
import com.example.LearnToDevlop.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
    @RequiredArgsConstructor

    public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public String register(RegisterRequest req) {
        if (userRepository.existsByUsername(req.username()))
            throw new RuntimeException("Username already taken");
        if (userRepository.existsByEmail(req.email()))
            throw new RuntimeException("Email already in use");

        Role role = (req.role() != null && !req.role().isBlank())
                ? Role.valueOf(req.role()) : Role.EMPLOYEE;

        userRepository.save(User.builder()
                .username(req.username())
                .email(req.email())
                .password(passwordEncoder.encode(req.password()))
                .fullName(req.fullName())
                .role(role)
                .build());

        return "Registered successfully as " + role;
    }

    public AuthResponse login(LoginRequest req) {
        var auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.username(), req.password()));
        User user = (User) auth.getPrincipal();
        String token = jwtUtil.generate(user.getUsername());
        return new AuthResponse(token, user.getUsername(), user.getRole().name());
    }

    public String logout(String header) {
        if (header != null && header.startsWith("Bearer ")) {
            jwtUtil.blacklist(header.substring(7));
        }
        return "Logged out successfully";
    }
}