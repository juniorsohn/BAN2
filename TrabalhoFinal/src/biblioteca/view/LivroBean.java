package biblioteca.view;
import java.util.ArrayList;
import java.util.List;


public class LivroBean {
    private int nro_livro;
    private String titulo;
    private List<String> autores;
    private int ISBN;
    private String editora;
    private String colecao;

    public LivroBean(int nro_livro, String titulo, ArrayList<String> autores, int ISBN, String editora, String colecao) {
        this.nro_livro = nro_livro;
        this.titulo = titulo;
        this.autores = autores;
        this.ISBN = ISBN;
        this.editora = editora;
        this.colecao = colecao;
    }

    public LivroBean(){

    }

    public LivroBean(int nro_livro, String titulo, int isbn, String editora, String colecao) {
        this.nro_livro = nro_livro;
        this.titulo = titulo;
        this.ISBN = isbn;
        this.editora = editora;
        this.colecao = colecao;

    }

    public int getNro_livro() {
        return nro_livro;
    }

    public void setNro_livro(int nro_livro) {
        this.nro_livro = nro_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getColecao() {
        return colecao;
    }

    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    @Override public String toString(){
        return "Livro{"+ "ID: "+nro_livro+", titulo: "+titulo+", isbn: +"+ISBN+", editora: "+editora+", colecao: "+colecao;
    }
}
