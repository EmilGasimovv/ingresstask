package com.example.ingressacademytask.domains;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long authorId;
    String name;
    int age;
    @OneToMany()
    List<Books> authoredBooks;
}
