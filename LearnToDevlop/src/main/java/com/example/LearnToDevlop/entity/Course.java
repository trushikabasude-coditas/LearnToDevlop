package com.example.LearnToDevlop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String technology;
    private String duration;
    @OneToMany(mappedBy = "course",cascade =CascadeType.ALL, orphanRemoval = true )
    @Builder.Default
    private List<Module> modules=new ArrayList<>();
}
