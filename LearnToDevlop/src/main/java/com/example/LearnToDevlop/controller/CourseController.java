package com.example.LearnToDevlop.controller;

import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.dto.CourseRequest;
import com.example.LearnToDevlop.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping
    public ResponseEntity<ApiResponse<CourseRequest>> add(@RequestBody CourseRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<> (true, "Course Created Succesfully!!", courseService.add(dto)));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseRequest>>>getAll(){
        return ResponseEntity.ok(new ApiResponse<>(true,"Courses fetched !!",courseService.getAll()));
    }
    @GetMapping("{/id}")
    public ResponseEntity<ApiResponse<CourseRequest>>getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course fetched", courseService.getById(id))
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseRequest>>update(@PathVariable Long id, @RequestBody CourseRequest dto){
        return ResponseEntity.ok(
                new ApiResponse<>(true,"Course updated successfully",courseService.update(id,dto))
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>>delete(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true,"Course deleted",null)
        );
    }

}
