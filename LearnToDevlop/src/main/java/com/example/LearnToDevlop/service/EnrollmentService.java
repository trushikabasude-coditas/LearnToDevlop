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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private  final  UserRepository userRepository;

    private  final  CourseRepository courseRepository;

    private  final EnrollmentRepository enrollmentRepository;
//user entroll
   public Enrollment enroll(Long userId,Long courseId){
      if(enrollmentRepository.existsByUserIdAndCourseId(userId,courseId))
          throw new RuntimeException("User already enrolled for this course");
       User user = userRepository.findById(userId)
               .orElseThrow(() -> new ResourceNotFoundException("User not found"));

       Course course = courseRepository.findById(courseId)
               .orElseThrow(() -> new ResourceNotFoundException("Course not found"));


         Enrollment e = new Enrollment();
         e.setUser(user);
         e.setCourse(course);
        e.setProgress(0);
       return enrollmentRepository.save(e);
   }
   public List<Enrollment> getByUser(Long userId){
       return enrollmentRepository.findByUserId(userId);
   }

    public List<Enrollment> getByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }



}
