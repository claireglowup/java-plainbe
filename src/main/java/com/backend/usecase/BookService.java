package com.backend.usecase;

import java.util.List;
import java.util.Optional;

import com.backend.api.repository.BookRepository;
import com.backend.entity.Book;

public class BookService {
    
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }


    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(long id, Book book) {
        if (bookRepository.existById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }

    public boolean deleteBook(long id) {
        if (bookRepository.existById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

 