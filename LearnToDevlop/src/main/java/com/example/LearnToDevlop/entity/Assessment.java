package com.example.LearnToDevlop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessments")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tittle;
    private int totalMarks;
    private int passedMarks;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",nullable = false,unique = true)
    private Course course;



}
