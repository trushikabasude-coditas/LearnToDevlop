package com.example.LearnToDevlop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


public record CourseRequest (@NotBlank String title,
                             @NotBlank String description,
                             String technology,
                             String duration)
{}
