package biblioteca.view;

public class AssistenteBean extends FuncionarioBean{

    private int cod_assistente;

    public AssistenteBean(){
        
    }

    public AssistenteBean(int cpf, String nome, int id_funcionario, int cod_assistente) {
        super(cpf, nome, id_funcionario);
        this.cod_assistente = cod_assistente;
    }

    public int getCod_assistente() {
        return cod_assistente;
    }

    public void setCod_assistente(int cod_assistente) {
        this.cod_assistente = cod_assistente;
    }

    @Override public String toString() {
        return "Assistentes{" + "id=" + getId_funcionario() + ", nome=" + getNome()+ ", cpf: "+getCpf()+", cod_assistente: "+getCod_assistente()+'}';
    }
}
