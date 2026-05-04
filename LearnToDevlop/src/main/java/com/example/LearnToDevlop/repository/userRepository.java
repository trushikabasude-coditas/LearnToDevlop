package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.dto.UserDTO;
import com.example.LearnToDevlop.entity.User;
import org.apache.catalina.UserDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<UserDTO,Integer> {
}
