package com.br.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_lancamento;
    private String resumo;
    private String foto;
    private Boolean reservado = Boolean.FALSE;
    @ManyToOne
    @JoinColumn(name = "colecao_id")
    private Collection colecao;
    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Session sessao;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Author autor;

    public Book() {
    }

    public Book(String nome, Date data_lancamento, String resumo, String foto) {
        this.nome = nome;
        this.data_lancamento = data_lancamento;
        this.resumo = resumo;
        this.foto = foto;
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

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public Collection getColecao() {
        return colecao;
    }

    public void setColecao(Collection colecao) {
        this.colecao = colecao;
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }
}
