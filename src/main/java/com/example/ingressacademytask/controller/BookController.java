package com.example.ingressacademytask.controller;

import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    @GetMapping()
    public List<Books> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{bookId}")
    public Books getById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }
    @PostMapping()
    public Books addBook(@RequestBody Books book){
        return bookService.createBook(book);
    }
    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }
    @PutMapping("/{bookId}")
    public Books uptadeBook(@PathVariable Long bookId, @RequestBody Books books){
        return bookService.updateBook(bookId,books);
    }
}
