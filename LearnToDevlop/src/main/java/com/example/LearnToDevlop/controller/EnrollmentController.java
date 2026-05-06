package com.example.LearnToDevlop.controller;

import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.entity.Enrollment;
import com.example.LearnToDevlop.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.example.LearnToDevlop.entity.User;
import java.util.List;
@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    //enroll in course
    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> enroll(
            @AuthenticationPrincipal User user,
            @RequestParam Long courseId) {
        return ResponseEntity.status(201).body(ApiResponse.ok("Enrolled successfully",
                enrollmentService.enroll(user.getId(), courseId)));
    }
//all my enrollments
// Employee marks course as completed
@PatchMapping("/complete")
public ResponseEntity<ApiResponse<Enrollment>> complete(
        @AuthenticationPrincipal User user,
        @RequestParam Long courseId) {
    return ResponseEntity.ok(ApiResponse.ok("Course completed",
            enrollmentService.completeCourse(user.getId(), courseId)));
}
    @GetMapping("/my")
    public ResponseEntity<ApiResponse<List<Enrollment>>> my(
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(ApiResponse.ok("My enrollments",
                enrollmentService.myEnrollments(user.getId())));
    }

//list of empl r]enroll to that course
// Admin sees who enrolled in a course
@GetMapping("/course/{courseId}")
public ResponseEntity<ApiResponse<List<Enrollment>>> byCourse(
        @PathVariable Long courseId) {
    return ResponseEntity.ok(ApiResponse.ok("Enrollments fetched",
            enrollmentService.getByCourse(courseId)));
    }
}
