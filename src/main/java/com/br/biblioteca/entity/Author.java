package com.br.biblioteca.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String informacoes_autor;
    @OneToMany(mappedBy = "autor",fetch = FetchType.LAZY)
    private List<Book> listaLivros;

    public Author() {
    }

    public Author(UUID id, String nome, String informacoes_autor) {
        this.id = id;
        this.nome = nome;
        this.informacoes_autor = informacoes_autor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInformacoes_autor() {
        return informacoes_autor;
    }

    public void setInformacoes_autor(String informacoes_autor) {
        this.informacoes_autor = informacoes_autor;
    }

    public List<Book> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Book> listaLivros) {
        this.listaLivros = listaLivros;
    }
}
