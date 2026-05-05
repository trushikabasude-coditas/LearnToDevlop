package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.Course;
import com.example.LearnToDevlop.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
List<Module> findByCourseIdOrderByModuleOrderAsc(Long courseId);

}
