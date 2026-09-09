
@Repository
public class Acervo {
    private List<Livro> livros;

    public Acervo() {
        this.livros = new ArrayList<>();
        this.livros.add(new Livro(1, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943));
        this.livros.add(new Livro(2, "Dom Casmurro", "Machado de Assis", 1899));
        this.livros.add(new Livro(3, "1984", "George Orwell", 1949));
        this.livros.add(new Livro(4, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        this.livros.add(new Livro(5, "A Revolução dos Bichos", "George Orwell", 1945));
        this.livros.add(new Livro(6, "O Hobbit", "J.R.R. Tolkien", 1937));
        this.livros.add(new Livro(7, "Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881));
        this.livros.add(new Livro(8, "O Alquimista", "Paulo Coelho", 1988));
        this.livros.add(new Livro(9, "Cem Anos de Solidão", "Gabriel García Márquez", 1967));
        this.livros.add(new Livro(10, "O Código Da Vinci", "Dan Brown", 2003));
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<String> getListaAutores() {
        return livros.stream()
                .map(l -> l.getAutor())
                .toList();
    }

    public List<Livro> getLivrosDoAutor(String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor.trim()))
                .toList();
    }

    public boolean cadastraLivroNovo(Livro livro) {
        this.livros.add(livro);
        return true;
    }

    public List<Livro> getLivrosPorAno(int ano) {
        return livros.stream()
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    public List<Livro> getLivrosDesatualizados(int ano) {
        return livros.stream()
                .filter(livro -> livro.getAno() < ano)
                .toList();
    }

     public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor.trim()))
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    public boolean atualizaLivro(Livro livroAtualizado) {
        Optional<Livro> livroOp = livros.stream()
            .filter(l->l.getId() == livroAtualizado.getId())
            .findAny();
        if (livroOp.isPresent()){
            livros.remove(livroOp.get());
            livros.add(livroAtualizado);
        }
        return true;
    }
}
