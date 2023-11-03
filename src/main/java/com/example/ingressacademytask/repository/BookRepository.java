package com.example.ingressacademytask.repository;

import com.example.ingressacademytask.domains.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books,Long> {
}
