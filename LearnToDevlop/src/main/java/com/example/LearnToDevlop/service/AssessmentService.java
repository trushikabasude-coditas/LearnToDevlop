package com.example.LearnToDevlop.service;

import com.example.LearnToDevlop.entity.Assessment;
import com.example.LearnToDevlop.entity.AssessmentStatus;
import com.example.LearnToDevlop.entity.Certificate;
import com.example.LearnToDevlop.entity.Enrollment;
import com.example.LearnToDevlop.entity.EnrollmentStatus;
import com.example.LearnToDevlop.exception.ResourceNotFoundException;
import com.example.LearnToDevlop.repository.AssessmentRepository;
import com.example.LearnToDevlop.repository.CertificateRepository;
import com.example.LearnToDevlop.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CertificateRepository certificateRepository;

    public Assessment submit(Long enrollmentId, boolean passed) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));

        if (enrollment.getStatus() != EnrollmentStatus.COMPLETED)
            throw new RuntimeException("Complete course first before taking assessment");

        if (assessmentRepository.findByEnrollmentId(enrollmentId).isPresent())
            throw new RuntimeException("Assessment already submitted");

        Assessment a = new Assessment();
        a.setEnrollment(enrollment);
        a.setStatus(passed ? AssessmentStatus.PASSED : AssessmentStatus.FAILED);
        assessmentRepository.save(a);

        if (passed) {
            Certificate cert = new Certificate();
            cert.setUser(enrollment.getUser());
            cert.setCourse(enrollment.getCourse());
            certificateRepository.save(cert);
        }

        return a;
    }

    public List<Assessment> getAll() {
        return assessmentRepository.findAll();
    }
}