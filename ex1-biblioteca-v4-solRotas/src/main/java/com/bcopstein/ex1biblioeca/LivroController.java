package com.bcopstein.ex1biblioeca;

@RestController
public class LivroController {

    private final Acervo acervo;

    @Autowired
    public LivroController(Acervo acervo) {
        this.acervo = acervo;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return acervo.getLivros();
    }

    @PostMapping("/novolivro")
    @CrossOrigin(origins = "*")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return acervo.cadastraLivroNovo(livro);
    }

     @GetMapping("livrosporano")// livrosporano?ano=2023
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosPorAno(@RequestParam(value = "ano") int ano) {
        return acervo.getLivrosPorAno(ano);
    }

    @GetMapping("/desatualizados/{ano}") //desatualizados/2023
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@PathVariable(value="ano")int ano) {
        return acervo.getLivrosDesatualizados(ano);
    }

    @PostMapping("/atualiza")
    @CrossOrigin(origins = "*")
    public boolean atualizaLivro(@RequestBody final Livro livroAtualizado) {
        return acervo.atualizaLivro(livroAtualizado);
    }
}
