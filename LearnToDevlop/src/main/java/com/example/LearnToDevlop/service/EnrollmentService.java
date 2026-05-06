package com.example.LearnToDevlop.service;
import com.example.LearnToDevlop.entity.*;
import com.example.LearnToDevlop.exception.ResourceNotFoundException;
import com.example.LearnToDevlop.repository.*;
import com.example.LearnToDevlop.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    public Enrollment enroll(Long userId, Long courseId) {
        Objects.requireNonNull(userId, "User ID must not be null");
        Objects.requireNonNull(courseId, "Course ID must not be null");

        if (enrollmentRepository.existsByUserIdAndCourseId(userId, courseId))

            throw new RuntimeException("Already enrolled in this course");

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        Enrollment e = new Enrollment();
        e.setUser(user);
        e.setCourse(course);
        return enrollmentRepository.save(e);
    }
    public Enrollment completeCourse(Long userId, Long courseId) {
        Objects.requireNonNull(userId, "User ID must not be null");
        Objects.requireNonNull(courseId, "Course ID must not be null");

        Enrollment e = enrollmentRepository.findByUserIdAndCourseId(userId, courseId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        e.setStatus(EnrollmentStatus.COMPLETED);
        return enrollmentRepository.save(e);
    }
    public List<Enrollment> myEnrollments(Long userId) {
        Objects.requireNonNull(userId, "User ID must not be null");
        return enrollmentRepository.findByUserId(userId);
    }
    public List<Enrollment> getByCourse(Long courseId) {
        Objects.requireNonNull(courseId, "Course ID must not be null");
        return enrollmentRepository.findByCourseId(courseId);
    }
}