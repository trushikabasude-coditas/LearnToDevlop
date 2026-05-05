package com.example.LearnToDevlop.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "modules")
@Builder
public class CourseModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String resourceLink;
    private Integer moduleOrder;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",nullable = false)
    private Course  course;

}
