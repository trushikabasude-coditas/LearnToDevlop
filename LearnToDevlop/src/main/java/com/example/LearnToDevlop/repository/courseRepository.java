package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepository extends JpaRepository<Course,Long> {

}
