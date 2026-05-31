package nathalia.poo.ufpb;
import java.util.ArrayList;
import java.util.List;
public class SistemaDeBibliotecaTest {
     private List<Livro> acervo;

    public SistemaDeBibliotecaTest() {
        this.acervo = new ArrayList<>();
    }
    public void cadastrarLivro(Livro novoLivro) throws LivroJaExisteException {
        if (acervo.contains(novoLivro)) {
            throw new LivroJaExisteException("Já existe um livro cadastrado com o ISBN: " + novoLivro.getIsbn());
        }
        acervo.add(novoLivro);
        System.out.println("Livro '" + novoLivro.getTitulo() + "' adicionado com sucesso!");
    }
    public List<Livro> listarLivros() {
        return new ArrayList<>(this.acervo);
    }
}

