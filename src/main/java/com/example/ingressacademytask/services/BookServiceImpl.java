package com.example.ingressacademytask.services;

import com.example.ingressacademytask.domains.Author;
import com.example.ingressacademytask.domains.Books;
import com.example.ingressacademytask.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    @Override
    public Books createBook(Books books) {
        Author author = authorService.getAuthorById(books.getId());
        if(author!=null){
            Books addedBooks = new Books();
            addedBooks.setName(books.getName());
            addedBooks.setAuthor(author);
            return bookRepository.save(addedBooks);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Books updateBook(Long id, Books books) {
        Books updatedBook = bookRepository.findById(id).orElseThrow();
        Author author = authorService.getAuthorById(books.getId());
        if (author!=null){
            updatedBook.setAuthor(author);
            updatedBook.setName(books.getName());
            return bookRepository.save(updatedBook);
        }
        else{
            return null;
        }

    }

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }
}
