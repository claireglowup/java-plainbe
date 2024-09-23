package com.backend.api.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.backend.entity.Book;
import com.backend.usecase.BookService;

@Path("/books")
public class BookResource {
    
    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam("id") Long id)  {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(b -> Response.ok(b))  // Menggunakan lambda untuk mengembalikan buku
                   .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }
    

}
