package biblioteca.view;

import java.util.List;

public class UsuarioBean {
    private int idUsuario;
    private int valorMulta, qntLivros;
    private String nome, endereco;
    private List<Integer> telefones;
    private int categoria; // Categoria: 1 = Graduação; 2 = Pós-Graduação: 3 = Professor; 4 = Professór Pós;

    public UsuarioBean(){

    }

    public UsuarioBean(int idUsuario, int valorMulta, int qntLivros, String nome, String endereco, List<Integer> telefones, int categoria) {
        this.idUsuario = idUsuario;
        this.valorMulta = valorMulta;
        this.qntLivros = qntLivros;
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = telefones;
        this.categoria = categoria;
    }

    public UsuarioBean(int anInt, String string, String string1, int anInt1, int anInt2, int anInt3) {
        this.idUsuario = anInt;
        this.valorMulta = anInt3;
        this.qntLivros = anInt2;
        this.nome = string;
        this.endereco = string1;
        this.categoria = anInt1;
    }

    public UsuarioBean(int anInt, String string) {
        this.idUsuario = anInt;
        this.nome = string;

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(int valorMulta) {
        this.valorMulta = valorMulta;
    }

    public int getQntLivros() {
        return qntLivros;
    }

    public void setQntLivros(int qntLivros) {
        this.qntLivros = qntLivros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Integer> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Integer> telefones) {
        this.telefones = telefones;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override public String toString() {
        return "Usuario{" + "id=" + idUsuario + ", nome=" + nome+ ", qntLivros: "+qntLivros+ ", valor_multa: "+valorMulta+ '}';
    }
}
