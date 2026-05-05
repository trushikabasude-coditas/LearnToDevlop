package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.AssessmentResult;

import java.util.List;

public interface ResultRepository {
 List<AssessmentResult> findByAssessmentId(Long assessmentId);
 boolean existByUserIdAndAssessmentId(Long userId, Long assessmentId);

}
