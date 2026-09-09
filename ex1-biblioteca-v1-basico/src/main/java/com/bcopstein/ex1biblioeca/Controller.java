package com.bcopstein.ex1biblioeca;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private List<Livro> listaLivros;

    public Controller(){
        this.listaLivros = new LinkedList<>();
        this.listaLivros.add(new Livro(1, "Dom Casmurro", "Machado de Assis", 1899));
        this.listaLivros.add(new Livro(2, "1984", "George Orwell", 1949));
        this.listaLivros.add(new Livro(3, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return this.listaLivros;
    }

    @PostMapping("/novolivro")
    @CrossOrigin(origins = "*")
    public void adicionaLivro(@RequestBody Livro livro){
        this.listaLivros.add(livro);
    }

    @GetMapping("/titulo")
    @CrossOrigin(origins = "*")
    public String getTitulosLivros(){
        StringBuilder titulos = new StringBuilder();

        for(Livro livro : this.listaLivros){
            titulos.append(livro.getTitulo());
        }

        return titulos.toString();
    }

    @GetMapping("/livrosporano")
    @CrossOrigin(origins = "*")
    public List<Livro> livrosPorAno(@RequestParam(value = "ano") String ano){
        return livros.stream()
        .filter(livro -> livro.getAno().equals(ano.trim()))
        .toList();
    }

    @GetMapping("/livrosdesatualizados/{ano}")
    @CrossOrigin(origins = "*")
    public List<Livro> livrosDesatualizados(@PathVariable(value="ano") int ano){
        return livrosDesatualizados.stream()
        .filter(livro -> livro.getAno() < ano)
        .toList();
    }
}
