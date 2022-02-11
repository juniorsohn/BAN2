package biblioteca.view;

public class FuncionarioBean {
    private int cpf;
    private String nome;
    private int id_funcionario;

    public FuncionarioBean(){

    }

    public FuncionarioBean(int id_funcionario, String nome,  int cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.id_funcionario = id_funcionario;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    @Override public String toString(){
        return "Funcionarios{ id: "+id_funcionario+ ", nome: "+nome+", cpf: "+cpf+"}";
    }
}
