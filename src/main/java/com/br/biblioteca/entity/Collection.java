package com.br.biblioteca.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_collection")
public class Collection {

    @Id
    private UUID id;
    private String nome;

    @OneToMany(mappedBy = "colecao",fetch = FetchType.LAZY)
    private List<Book> listaLivros;

    public Collection() {
    }

    public Collection(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Book> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Book> listaLivros) {
        this.listaLivros = listaLivros;
    }
}
