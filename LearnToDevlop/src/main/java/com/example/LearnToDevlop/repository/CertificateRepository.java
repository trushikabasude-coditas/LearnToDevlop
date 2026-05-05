package com.example.LearnToDevlop.repository;

import com.example.LearnToDevlop.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository  extends JpaRepository<Certificate,Long> {

    List<Certificate> findByUserId(Long userId);
}

