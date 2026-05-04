package com.example.LearnToDevlop.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class SubmissionDTO {
    private Long assignmentId;
    private Long userId;
}
