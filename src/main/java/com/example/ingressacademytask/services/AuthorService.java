package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();
    Author getAuthorById(Long id);
    void deleteAuthor(Long id);
    Author updateAuthor(Long id, Author author);
}
