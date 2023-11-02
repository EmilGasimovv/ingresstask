package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAll();
}
