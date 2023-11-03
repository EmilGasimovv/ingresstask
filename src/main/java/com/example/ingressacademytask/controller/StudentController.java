package com.example.ingressacademytask.controller;

import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.dto.StudentDto;
import com.example.ingressacademytask.dto.StudentRequest;
import com.example.ingressacademytask.dto.StudentResponse;
import com.example.ingressacademytask.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentResponse> save(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<StudentResponse> auth(@RequestBody StudentRequest studentRequest){
        return ResponseEntity.ok(studentService.auth(studentRequest));

    }
//    public Student createStudent(@RequestBody Student studentDto){
//        return studentService.createStudent(studentDto);
//    }






//    @GetMapping()
//    public List<Student> getAll(){
//        return studentService.getAll();
//    }
//    @GetMapping("/{studentId}")
//    public Student getById(@PathVariable Long studentId){
//        return studentService.getStudentById(studentId);
//    }
//    @PutMapping("/{studentId}")
//    public Student updateStudent(@PathVariable Long studentId,@RequestBody Student student){
//        return studentService.updateStudent(studentId,student);
//    }
//    @DeleteMapping("/{studentId}")
//    public void deleteStudentById(@PathVariable Long studentId){
//        studentService.deleteStudentById(studentId);
//    }

}
