package com.example.LearnToDevlop.service;

import com.example.LearnToDevlop.dto.CourseRequest;
import com.example.LearnToDevlop.dto.ModuleRequest;
import com.example.LearnToDevlop.entity.Course;
import com.example.LearnToDevlop.exception.ResourceNotFoundException;
import com.example.LearnToDevlop.repository.CourseRepository;
import com.example.LearnToDevlop.repository.ModuleRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private  CourseRepository courseRepository;
    private ModuleRepository moduleRepository;
    public Course add(CourseRequest dto) {
        Course c = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .technology(dto.getTechnology())
                .duration(dto.getDuration())
                .build();
        return courseRepository.save(c);
    }
    public List <Course> getAll(){
        return courseRepository.findAll();

    }
    public Course getById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }
    public Course update(Long id, CourseRequest dto) {
        Course c = getById(id);
        c.setTitle(dto.getTitle());
        c.setDescription(dto.getDescription());
        c.setTechnology(dto.getTechnology());
        c.setDuration(dto.getDuration());
        return courseRepository.save(c);
    }

    public void delete(Long id) {
        if (!courseRepository.existsById(id))
            throw new ResourceNotFoundException("Course not found with id: " + id);
        courseRepository.deleteById(id);
    }

    public Module addModule(Long courseId, ModuleRequest dto) {
        Course c = getById(courseId);
        Module m = Module.builder()
                .title(dto.title())
                .content(dto.content())
                .resourceLink(dto.resourceLink())
                .moduleOrder(dto.moduleOrder())
                .course(c)
                .build();
        return moduleRepository.save(m);
    }

}
