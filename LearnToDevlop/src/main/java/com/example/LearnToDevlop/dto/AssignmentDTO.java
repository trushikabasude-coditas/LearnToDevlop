package com.example.LearnToDevlop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDTO {
    private String name;
    private String details;
    private int maxScore;
    private Long courseId;
}
