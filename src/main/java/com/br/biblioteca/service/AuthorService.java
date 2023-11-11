package com.br.biblioteca.service;

import com.br.biblioteca.dtos.AuthorDto;
import com.br.biblioteca.dtos.BookDto;
import com.br.biblioteca.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    Author findById(UUID authorId);
    List<Author> findAll();
    Author createAuthor(AuthorDto author);
    void deleteAuthor(UUID authorId);
    Author addBooks(UUID authorId, UUID  bookId);
}
