package nathalia.poo.ufpb;
import java.util.Objects;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int paginas;


    public Livro(){}

    public Livro (String isbn, String titulo, String autor, int paginas){
        this.isbn=isbn;
        this.titulo=titulo;
        this.autor=autor;
        this.paginas=paginas;
    }
    public boolean ehLongo() {
        return this.paginas > 500;
    }
    public String getIsbn (){
        return isbn;
    }
    public void setIsbn(String isbn){
         this.isbn=isbn;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo (String titulo){
        this.titulo=titulo;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor=autor;
    }
    public int getPaginas(){
        return paginas;
    }
    public void setPaginas(int paginas){
        this.paginas=paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return paginas == livro.paginas && Objects.equals(isbn, livro.isbn) && Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }
    @Override
    public String toString (){
        return "Livro:" +
            "ISBN:'" + isbn +
                    ", Título:'" + titulo  +
                    ", Autor:'" + autor  +
                    ", Quantidade de páginas:" + paginas;
    }

}
