package com.br.biblioteca.service.implementation;

import com.br.biblioteca.dtos.AuthorDto;
import com.br.biblioteca.entity.Author;
import com.br.biblioteca.entity.Book;
import com.br.biblioteca.repository.AuthorRepository;
import com.br.biblioteca.repository.BookRepository;
import com.br.biblioteca.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorServiceImp implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImp(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author findById(UUID authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        return author.orElseThrow(() -> new RuntimeException("teste"));
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(AuthorDto author) {
        Author newAuthor = new Author();
        newAuthor.setNome(author.getNome());
        newAuthor.setInformacoes_autor(author.getInformacoes());
        authorRepository.save(newAuthor);
        return newAuthor;
    }

    @Override
    public void deleteAuthor(UUID authorId) {
        Author author = findById(authorId);
        authorRepository.delete(author);
    }

    @Override
    public Author addBooks(UUID authorId, UUID bookId) {
        Author author = findById(authorId);
        Book book = bookRepository.findById(bookId).get();
        author.getListaLivros().add(book);
        authorRepository.save(author);
        return author;
    }
}
