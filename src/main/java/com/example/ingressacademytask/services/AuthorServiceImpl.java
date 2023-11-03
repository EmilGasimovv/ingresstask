package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;



    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteAuthor(Long id) {
      authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author updatedAuthor = authorRepository.findById(id).orElseThrow();
        if(updatedAuthor!=null){
            updatedAuthor.setName(author.getName());
            updatedAuthor.setEmail(author.getEmail());
            updatedAuthor.setPassword(author.getPassword());
            updatedAuthor.setAge(author.getAge());
        }
        return null;
    }
}
