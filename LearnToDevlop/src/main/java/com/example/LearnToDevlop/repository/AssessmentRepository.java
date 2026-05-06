package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    Optional<Assessment> findByEnrollmentId(Long enrollmentId);
}
