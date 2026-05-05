package com.example.LearnToDevlop.controller;

import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.dto.CourseRequest;
import com.example.LearnToDevlop.dto.ModuleRequest;
import com.example.LearnToDevlop.entity.Course;
import com.example.LearnToDevlop.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

        @RestController
        @RequestMapping("/api/courses")
        @RequiredArgsConstructor
        public class CourseController {

            private final CourseService courseService;

            @PostMapping
            public ResponseEntity<ApiResponse<Course>> add(@Valid @RequestBody CourseRequest dto) {
                return ResponseEntity.status(201).body(ApiResponse.ok("Course created", courseService.add(dto)));
            }

            @GetMapping
            public ResponseEntity<ApiResponse<List<Course>>> getAll() {
                return ResponseEntity.ok(ApiResponse.ok("Courses fetched", courseService.getAll()));
            }

            @GetMapping("/{id}")
            public ResponseEntity<ApiResponse<Course>> getById(@PathVariable Long id) {
                return ResponseEntity.ok(ApiResponse.ok("Course fetched", courseService.getById(id)));
            }

            @PutMapping("/{id}")
            public ResponseEntity<ApiResponse<Course>> update(@PathVariable Long id,
                                                              @Valid @RequestBody CourseRequest dto) {
                return ResponseEntity.ok(ApiResponse.ok("Course updated", courseService.update(id, dto)));
            }

            @DeleteMapping("/{id}")
            public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
                courseService.delete(id);
                return ResponseEntity.ok(ApiResponse.ok("Course deleted"));
            }

            @PostMapping("/{id}/modules")
            public ResponseEntity<ApiResponse<Module>> addModule(@PathVariable Long id,
                                                                 @Valid @RequestBody ModuleRequest dto) {
                return ResponseEntity.status(201).body(ApiResponse.ok("Module added", courseService.addModule(id, dto)));
            }
        }
