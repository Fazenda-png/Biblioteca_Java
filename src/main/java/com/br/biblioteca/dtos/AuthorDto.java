package com.br.biblioteca.dtos;

public class AuthorDto {

    private String nome;
    private String informacoes;

    public AuthorDto(String nome, String informacoes) {
        this.nome = nome;
        this.informacoes = informacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}
