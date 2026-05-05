package com.example.LearnToDevlop.service;
import com.example.LearnToDevlop.repository.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssessmentService {
       @Autowired
    private AssessmentRepository assessmentRepository;

       public AssessmentRepository getAssessmentRepository() {
            return assessmentRepository;
       }



}
