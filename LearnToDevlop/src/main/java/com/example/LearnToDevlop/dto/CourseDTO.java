package com.example.LearnToDevlop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {
    private  Long id;
    private  String name;
    private  String description;
    private String technology;
    private String duration;
    private String link;

}
