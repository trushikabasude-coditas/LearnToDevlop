package com.example.LearnToDevlop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Submission {
    private Long id;
    @ManyToOne
    private Assignment assignment;
    @ManyToOne
    private User user;
    private int score;
    private String status;
}
