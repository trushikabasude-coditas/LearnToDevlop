package com.example.LearnToDevlop.controller;

import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.entity.Assessment;
import com.example.LearnToDevlop.service.AssessmentService;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final AssessmentService assessmentService;

    @PostMapping("/submit")
    public ResponseEntity<ApiResponse<Assessment>> submitAssessment(@RequestParam() Long enrollmentId, @RequestParam() boolean passed) {
        Assessment a = assessmentService.submit(enrollmentId, passed);
        String message = passed ? "success!!Assesment passed Successfully! Heres Your certificate!" : "Assessment failed. Better luck next time.";
        return ResponseEntity.ok(ApiResponse.ok(message, a));

    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Assessment>>> getAssessment() {
        return ResponseEntity.ok(ApiResponse.ok("Assessment lists:", assessmentService.getAll()));

    }
}



