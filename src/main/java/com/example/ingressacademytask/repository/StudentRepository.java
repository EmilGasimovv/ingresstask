package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
