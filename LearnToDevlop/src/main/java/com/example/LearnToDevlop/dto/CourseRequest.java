package com.example.LearnToDevlop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    @NotBlank String title;
    @NotBlank String description;
    String technology;
    String duration;
}