package com.example.LearnToDevlop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @ManyToOne
    @JoinColumn(name = "enrollment_id")
//    @JsonIgnore
    private Enrollment enrollment;

    @Enumerated(EnumType.STRING)
    private AssessmentStatus status;

    private LocalDateTime attemptAt;
//    private String tittle;
//    private int totalMarks;
//    private int passedMarks;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "course_id",nullable = false,unique = true)
//    private Course course;
@PrePersist
void prePersist() { attemptAt = LocalDateTime.now();
}


}
