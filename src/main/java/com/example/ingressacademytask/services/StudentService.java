package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.dto.StudentDto;
import com.example.ingressacademytask.dto.StudentRequest;
import com.example.ingressacademytask.dto.StudentResponse;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentResponse createStudent(StudentDto studentDto);
    List<Student> getAll();
    Student getStudentById(Long id);
    void deleteStudentById(Long id);
    Student updateStudent(Long id, Student student);

   StudentResponse auth(StudentRequest studentRequest);
}
