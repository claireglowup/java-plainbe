package com.backend.api.repository;

import java.util.List;
import java.util.Optional;

import com.backend.entity.Book;


public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(long id);
    Book save(Book book);
    void deleteById(long id);
    boolean existById(long id);
}
