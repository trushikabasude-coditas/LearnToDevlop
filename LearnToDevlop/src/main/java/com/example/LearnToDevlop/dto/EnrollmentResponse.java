package com.example.LearnToDevlop.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {
    private Long id;
    private UserDTO user;
    private String courseTitle;
    private String status;
    private LocalDateTime enrolledAt;
}
