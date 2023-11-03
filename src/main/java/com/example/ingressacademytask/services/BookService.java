package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Books;

import java.util.List;

public interface BookService {
    Books createBook(Books books);
    void deleteBook(Long id);
    Books updateBook(Long id, Books books);
    List<Books> getAllBooks();
    Books getBookById(Long id);
}
