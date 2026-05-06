package com.example.LearnToDevlop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String certificateNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"password", "role", "authorities",
            "accountNonExpired", "accountNonLocked", "credentialsNonExpired", "enabled"})

    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties({"modules"})
    private Course course;
  private LocalDateTime issuedAt;
    @PrePersist
    void prePersist() {
        issuedAt = LocalDateTime.now();
        certificateNumber = "CERT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
