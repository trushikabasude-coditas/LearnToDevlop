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
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name="course_id")
    private Course course;
    private int progress;
    private LocalDateTime enrolledAt;

    @PrePersist
    void prePersist()
    { enrolledAt = LocalDateTime.now();
    }
}
