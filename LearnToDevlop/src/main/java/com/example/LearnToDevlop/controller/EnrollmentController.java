package com.example.LearnToDevlop.controller;

import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.entity.Enrollment;
import com.example.LearnToDevlop.service.EnrollmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enroll")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
@PostMapping
public ResponseEntity<ApiResponse<Enrollment>> enroll(
        @RequestParam Long userId,
        @RequestParam Long courseId){
    return ResponseEntity.status(201).body(ApiResponse.ok("Enrolled Successfully into the course",enrollmentService.enroll(userId,courseId)));
}
@GetMapping("/user/{userId}")
public ResponseEntity<ApiResponse<List<Enrollment>>> getByUser(@PathVariable Long userId){
    return ResponseEntity.ok(ApiResponse.ok("Enrollments are here!!",enrollmentService.getByUser(userId)));
}
    @GetMapping("/course/{courseId}")//couse 1 users enrolled list
    public ResponseEntity<ApiResponse<List<Enrollment>>> getByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(ApiResponse.ok("Enrollments fetched", enrollmentService.getByCourse(courseId)));
}
}
