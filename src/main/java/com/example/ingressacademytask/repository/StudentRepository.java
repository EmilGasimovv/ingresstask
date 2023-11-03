package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
}
