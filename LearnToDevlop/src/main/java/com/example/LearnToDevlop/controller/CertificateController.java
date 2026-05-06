package com.example.LearnToDevlop.controller;


import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.entity.Certificate;
import com.example.LearnToDevlop.entity.User;
import com.example.LearnToDevlop.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/certificates")
@RequiredArgsConstructor
public class CertificateController {
    private final CertificateRepository certificateRepository;
    @GetMapping("/my")
    public ResponseEntity<ApiResponse<List<Certificate>>> my(
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(ApiResponse.ok("Certificates fetched",
                certificateRepository.findByUserId(user.getId())));
    }
}
