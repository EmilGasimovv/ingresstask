package com.example.ingressacademytask.controller;

import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping()
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping()
    public List<Student> getAll(){
        return studentService.getAll();
    }

}
