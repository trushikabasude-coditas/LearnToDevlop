package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface enrollmentRepositroy extends JpaRepository<Enrollment,Long> {
}
