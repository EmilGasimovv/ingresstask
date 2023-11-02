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
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "student_reading",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Books> currentlyReadingBooks;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "student_subscriptions",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> subscriptions;

}
