package com.example.ingressacademytask.domains;

import ch.qos.logback.core.model.NamedModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long studentId;
    @Column(name = "STUDENT_NAME")
    String name;
    @Column(name = "STUDENT_AGE")
    int age;

}
