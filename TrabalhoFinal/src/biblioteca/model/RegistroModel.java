package biblioteca.model;

import biblioteca.view.LivroBean;
import biblioteca.view.RegistroBean;
import biblioteca.view.UsuarioBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class RegistroModel {


    public static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT data, data_devolucao, devolvido, reservado, renovado, id_usuario, nro_livro from registroemprestimo";
        ResultSet result = st.executeQuery(sql);


        while (result.next()) {
            list.add(new RegistroBean(result.getDate(1),result.getDate(2),result.getDate(3),result.getBoolean(4),result.getInt(5),result.getInt(6),result.getInt(7)));
        }

        return list;
    }

    public static RegistroBean escolheRegistro(int escolha_registro, Connection con) throws SQLException {
        RegistroBean rb = new RegistroBean();
        Statement st;
        st = con.createStatement();
        String sql = "SELECT data, data_devolucao, devolvido, reservado, renovado, id_usuario, nro_livro from registroemprestimo where id_usuario ="+escolha_registro+";";
        ResultSet result = st.executeQuery(sql);
        while (result.next()){
            rb = new RegistroBean(result.getDate(1),result.getDate(2),result.getDate(3),result.getBoolean(4),result.getInt(5),result.getInt(6),result.getInt(7));
        }

        return rb;
    }

    public static void renovaLivro(RegistroBean registro_escolhido, UsuarioBean ub, Connection con) throws SQLException {

        Statement st;
        st = con.createStatement();
        String sql = "Select renova_livro("+ub.getIdUsuario()+");";
        ResultSet result_renova = st.executeQuery(sql);
        while(result_renova.next()){
            System.out.println("Renovação bem-sucedida!");
        }
    }

    public static void reservaLivro(RegistroBean registro_escolhido, UsuarioBean ub, Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "Select reserva_livro("+ub.getIdUsuario()+");";
        ResultSet result_reserva = st.executeQuery(sql);
        while(result_reserva.next()){
            System.out.println("Reserva feita com sucesso!");
        }

    }
}
