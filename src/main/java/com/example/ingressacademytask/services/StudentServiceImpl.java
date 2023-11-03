package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Student;
import com.example.ingressacademytask.dto.StudentDto;
import com.example.ingressacademytask.dto.StudentRequest;
import com.example.ingressacademytask.dto.StudentResponse;
import com.example.ingressacademytask.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public StudentResponse createStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .age(studentDto.getAge())
                .password(studentDto.getPassword())
                .build();
        studentRepository.save(student);

        var token = jwtService.generateToken(student);
        return StudentResponse.builder().studentToken(token).build();
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student updatedtStudent = studentRepository.findById(id).get();
        if (updatedtStudent != null) {
            updatedtStudent.setName(student.getName());
            updatedtStudent.setEmail(student.getEmail());
            updatedtStudent.setAge(student.getAge());
            updatedtStudent.setPassword(student.getPassword());
            return studentRepository.save(updatedtStudent);
        }
        return null;
    }
    @Override
    public StudentResponse auth(StudentRequest studentRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(studentRequest.getStudentEmail(), studentRequest.getStudentPassword()));
        Student student = studentRepository.findByEmail(studentRequest.getStudentEmail()).orElseThrow();
        String token = jwtService.generateToken(student);
        return StudentResponse.builder().studentToken(token).build();
    }

}
