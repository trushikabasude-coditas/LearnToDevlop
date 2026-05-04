package com.example.LearnToDevlop.controller;

import com.example.LearnToDevlop.dto.ApiResponse;
import com.example.LearnToDevlop.dto.CourseDTO;
import com.example.LearnToDevlop.entity.Course;
import com.example.LearnToDevlop.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;
    @PostMapping
    public ResponseEntity<ApiResponse<CourseDTO>> add(@RequestBody CourseDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse() < > (true, "Course Created Succesfully!!", courseService.add(dto)));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseDTO>>>getAll(){
        return ResponseEntity.ok()(
                new ApiResponse<>(true,"Courses fetched !!",courseService.getAll())
                );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse>CourseDTO>>getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Course fetched", service.getById(id))
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseDTO>>update(@PathVariable Long id,@RequestBody CourseDTO dto){
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
