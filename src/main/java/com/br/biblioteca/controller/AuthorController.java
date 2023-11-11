package com.br.biblioteca.controller;

import com.br.biblioteca.dtos.AuthorDto;
import com.br.biblioteca.entity.Author;
import com.br.biblioteca.service.implementation.AuthorServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    private final AuthorServiceImp authorServiceImp;

    public AuthorController(AuthorServiceImp authorServiceImp) {
        this.authorServiceImp = authorServiceImp;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthorById(@RequestParam UUID authorId){
        Author author = authorServiceImp.findById(authorId);
        return ResponseEntity.ok().body(author);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> author = authorServiceImp.findAll();
        return ResponseEntity.ok().body(author);
    }
    @RequestMapping(value = "/createAuthor", method = RequestMethod.POST)
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDto authorDto){
        Author author = authorServiceImp.createAuthor(authorDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(author);
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAuthor(@RequestParam UUID authorId){
        authorServiceImp.deleteAuthor(authorId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/add/books", method = RequestMethod.PATCH)
    public ResponseEntity<Author> addBooks(UUID authorId, UUID bookId){
        Author author = authorServiceImp.addBooks(authorId, bookId);
        return ResponseEntity.ok().body(author);
    }
}
