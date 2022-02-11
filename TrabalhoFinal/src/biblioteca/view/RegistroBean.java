package biblioteca.view;

import java.util.Date;

public class RegistroBean {
        private Date data;
        private Date data_devolucao, devolvido;
        private boolean reservado;
        private int renovado, id_usuario, nro_livro;

        public RegistroBean(){

        }

        public RegistroBean(Date data, Date data_devolucao, Date devolvido, boolean reservado, int renovado, int id_usuario, int nro_livro) {
                this.data = data;
                this.data_devolucao = data_devolucao;
                this.devolvido = devolvido;
                this.reservado = reservado;
                this.renovado = renovado;
                this.id_usuario = id_usuario;
                this.nro_livro = nro_livro;
        }

        public Date getData() {
                return data;
        }

        public void setData(Date data) {
                this.data = data;
        }

        public Date getData_devolucao() {
                return data_devolucao;
        }

        public void setData_devolucao(Date data_devolucao) {
                this.data_devolucao = data_devolucao;
        }

        public Date getDevolvido() {
                return devolvido;
        }

        public void setDevolvido(Date devolvido) {
                this.devolvido = devolvido;
        }

        public boolean isReservado() {
                return reservado;
        }

        public void setReservado(boolean reservado) {
                this.reservado = reservado;
        }

        public int getRenovado() {
                return renovado;
        }

        public void setRenovado(int renovado) {
                this.renovado = renovado;
        }

        public int getId_usuario() {
                return id_usuario;
        }

        public void setId_usuario(int id_usuario) {
                this.id_usuario = id_usuario;
        }

        public int getNro_livro() {
                return nro_livro;
        }

        public void setNro_livro(int nro_livro) {
                this.nro_livro = nro_livro;
        }

        @Override
        public String toString() {
                return "Emprestimos{ nro_livro: "+nro_livro+", id_usuario: "+id_usuario+", data: "+data+ ", data_devolucao: "+data_devolucao+", reservado: "+reservado+", renovado: "+renovado;
        }
}
