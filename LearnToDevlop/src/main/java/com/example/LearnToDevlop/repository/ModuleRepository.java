package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<CourseModule, Long> {
    List<CourseModule> findByCourseIdOrderByModuleOrderAsc(Long courseId);
}