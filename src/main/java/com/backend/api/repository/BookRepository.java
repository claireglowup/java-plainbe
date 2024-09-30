package com.backend.api.repository;

import java.util.List;
import java.util.Optional;

import com.backend.entity.Book;


public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
    boolean existById(Long id);
}
