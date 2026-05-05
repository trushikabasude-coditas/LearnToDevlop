package com.example.LearnToDevlop.service;

import com.example.LearnToDevlop.Status;
import com.example.LearnToDevlop.dto.EnrollmentDTO;
import com.example.LearnToDevlop.entity.Course;
import com.example.LearnToDevlop.entity.Enrollment;
import com.example.LearnToDevlop.entity.User;
import com.example.LearnToDevlop.exception.ResourceNotFoundException;
import com.example.LearnToDevlop.repository.CourseRepository;
import com.example.LearnToDevlop.repository.EnrollmentRepository;
import com.example.LearnToDevlop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  CourseRepository courseRepository;
    @Autowired
    private  EnrollmentRepository enrollmentRepository;

   public EnrollmentDTO enroll(EnrollmentDTO dto){
       User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));

       Course course = courseRepository.findById(dto.getCourseId())
               .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

       Enrollment e=new Enrollment();
       e.setUser(user);
       e.setCourse(course);
       e.setProgress(0);
       enrollmentRepository.save(e);
       return dto;
   }

    public List<Enrollment> getUserCourses(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }


}
