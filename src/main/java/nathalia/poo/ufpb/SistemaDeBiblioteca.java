package nathalia.poo.ufpb;

import java.util.Scanner;

public class SistemaDeBiblioteca {
    public static void main (String [] args){
        SistemaDeBibliotecaTest sistema = new SistemaDeBibliotecaTest();
        Scanner leitor = new Scanner(System.in);

        try {
            sistema.cadastrarLivro(new Livro("978-85", "O Hobbit", "J.R.R. Tolkien", 336));
            sistema.cadastrarLivro(new Livro("978-85", "Design Patterns", "GoF", 400));
        } catch (LivroJaExisteException e) {
            System.out.println("[Tratamento de Erro]: " + e.getMessage());
        }
        try {
            Livro novo = new Livro();
            System.out.print("Digite o ISBN: ");
            novo.setIsbn(leitor.nextLine());

            System.out.print("Digite o Título: ");
            novo.setTitulo(leitor.nextLine());

            System.out.print("Digite o Autor: ");
            novo.setAutor(leitor.nextLine());

            System.out.print("Digite as Páginas (deve ser número): ");
            int paginas = leitor.nextInt();
            novo.setPaginas(paginas);

            sistema.cadastrarLivro(novo);

        } catch (LivroJaExisteException e) {
            System.err.println("[Erro de Negócio]: " + e.getMessage());
        } finally {
            leitor.close();
        }
        System.out.println("\n--- Relatório Final do Acervo ---");
        for (Livro l : sistema.listarLivros()) {
            System.out.println(l);
        }
    }
}
