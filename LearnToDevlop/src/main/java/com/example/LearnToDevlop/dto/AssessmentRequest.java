package com.example.LearnToDevlop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
public record AssessmentRequest (@NotBlank String title,int totalMarks,int passingMarks){

}
