package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDTO,Integer> {
    Optional<UserDTO> findByUsername(String username);
}
