package biblioteca.view;

public class BibliotecarioBean extends FuncionarioBean{
    private int cod_supervisor;


    public BibliotecarioBean(int id_funcionario, int cpf, String nome,  int cod_supervisor) {
        super(id_funcionario, nome, cpf);
        this.cod_supervisor = cod_supervisor;
    }

    public BibliotecarioBean(){

    }

    public BibliotecarioBean(int anInt, int anInt1) {

    }

    public BibliotecarioBean(int cod_supervisor, int id_funcionario, String nome) {
        this.cod_supervisor = cod_supervisor;
        this.setId_funcionario(id_funcionario);
        this.setNome(nome);

    }

    public int getCod_supervisor() {
        return cod_supervisor;
    }

    public void setCod_supervisor(int cod_supervisor) {
        this.cod_supervisor = cod_supervisor;
    }

    @Override public String toString() {
        return "Bibliotecario{"+ "id=" + getId_funcionario() + ", nome=" + getNome()+", cod_supervisor: "+getCod_supervisor()+'}';
    }
}
