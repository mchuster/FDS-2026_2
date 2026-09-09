package com.bcopstein.ex1biblioeca;

@RestController
public class AutorController {

    private final Acervo acervo;

    @Autowired
    public AutorController(Acervo acervo) {
        this.acervo = acervo;
    }

    @GetMapping("autores")
    @CrossOrigin(origins = "*")
    public List<String> getListaAutores() {
        return acervo.getAutores();
    }

    @GetMapping("livrosautor")// livrosautor?autor=Huguinho Pato
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return acervo.getLivrosDoAutor(autor);
    }

    @GetMapping("/livrosautor/{autor}/ano/{ano}") //livrosautor/Huguinho Pato/ano/2023
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return acervo.getLivrosDoAutor(autor, ano);
    }
}
