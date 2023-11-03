package com.example.ingressacademytask.controller;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping()
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthor();
    }
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author updateAuthor(@PathVariable Long authorId, @RequestBody Author author){
        return authorService.updateAuthor(authorId,author);
    }
    @DeleteMapping("/{authorId}")
    public void deleteAuthorById(@PathVariable Long authorId){
        authorService.deleteAuthor(authorId);
    }
}
