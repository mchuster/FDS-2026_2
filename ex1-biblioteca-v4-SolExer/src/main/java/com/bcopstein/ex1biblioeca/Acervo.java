package com.bcopstein.ex1biblioeca;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Acervo {
    private List<Livro> livros;

    public Acervo() {
        livros = new LinkedList<>();

        livros.add(new Livro(10, "Introdução ao Java", "Huguinho Pato", 2022));
        livros.add(new Livro(20, "Introdução ao Spring-Boot", "Zezinho Pato", 2020));
        livros.add(new Livro(15, "Principios SOLID", "Luizinho Pato", 2023));
        livros.add(new Livro(17, "Padroes de Projeto", "Lala Pato", 2019));
    }

    public List<Livro> getAll() {
        return livros;
    }

    public List<String> getTitulos() {
        return getAll()
                .stream()
                .map(livro -> livro.getTitulo())
                .toList();
    }

    public List<String> getAutores() {
        return getAll()
                .stream()
                .map(livro -> livro.getAutor())
                .toList();
    }

    public List<Livro> getLivrosDoAutor(String autor) {
        return getAll()
                .stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .toList();
    }

    public Livro getLivroTitulo(String titulo) {
        return getAll()
                .stream()
                .filter(livro -> livro.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

    public boolean cadastraLivroNovo(Livro livro) {
        livros.add(livro);
        return true;
    }

    public boolean removeLivro(long codigo) {
        return livros.removeIf(livro -> livro.getId() == codigo);
    }
}
