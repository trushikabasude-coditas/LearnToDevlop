package com.example.LearnToDevlop.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateResponse {
    private Long id;
    private String certificateNumber;
    private String username;
    private String courseTitle;
    private LocalDateTime issuedAt;
}
