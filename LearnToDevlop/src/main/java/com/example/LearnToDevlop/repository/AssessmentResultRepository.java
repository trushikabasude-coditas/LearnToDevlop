package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.AssessmentResult;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentResultRepository extends JpaRepository<AssessmentResult,Long> {
    List<AssessmentResult> findByAssessmentId(Long assessmentId);
    boolean existsByUserIdAndAssessmentId(Long userId,Long assessmentId);
    }
