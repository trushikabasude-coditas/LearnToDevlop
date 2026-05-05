package com.example.LearnToDevlop.dto;

import jakarta.validation.constraints.NotBlank;

public record ModuleRequest(@NotBlank String title,String content,String resourceLink,Integer moduleOrder) {
}
