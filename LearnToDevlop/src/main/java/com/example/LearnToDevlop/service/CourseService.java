package com.example.LearnToDevlop.service;

import com.example.LearnToDevlop.dto.CourseDTO;
import com.example.LearnToDevlop.entity.Course;
import com.example.LearnToDevlop.exception.ResourceNotFoundException;
import com.example.LearnToDevlop.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private  CourseRepository courseRepository;
    public CourseDTO add(CourseDTO dto) {
        Course c=new Course();
        c.setName(dto.getName());
        c.setTechnology(dto.getTechnology());
        c.setDuration(dto.getDuration());
        c.setLink(dto.getLink());
        return mapToDTO(courseRepository.save(c));
    }
    public List <CourseDTO> getAll(){
        return courseRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();

    }
    public CourseDTO getById(Long id) {
        Course c = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cource not found"));
        return mapToDTO(c);
    }
    public CourseDTO update(Long  id, CourseDTO dto) {
        Course c = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Courses not found"));

        c.setName(dto.getName());
        c.setTechnology(dto.getTechnology());
        c.setDuration(dto.getDuration());
        c.setLink(dto.getLink());
        return mapToDTO(courseRepository.save(c));

    }
    public void delete(Long id) {
        if(!courseRepository.existsById(id)){
            throw new ResourceNotFoundException("Course not found");
        }
        courseRepository.deleteById(id);
    }
    private CourseDTO mapToDTO(Course c){
        CourseDTO dto = new CourseDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setTechnology(c.getTechnology());
        dto.setDuration(c.getDuration());
        dto.setLink(c.getLink());
        return dto;
    }

}
