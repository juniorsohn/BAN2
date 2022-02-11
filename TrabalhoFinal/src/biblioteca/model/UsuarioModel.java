package biblioteca.model;

import biblioteca.view.UsuarioBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UsuarioModel {
    public static void create(UsuarioBean ub, Connection con) throws SQLException {
        PreparedStatement st;

        st = con.prepareStatement("INSERT INTO usuario (id_usuario, nome, endereco, categoria, qnt_livros, valor_multa)"
        + "VALUES (DEFAULT,?,?,?,?,?)");
        st.setString(1, ub.getNome());
        st.setString(2, ub.getEndereco());
        st.setInt(3, ub.getCategoria());
        st.setInt(4, ub.getQntLivros());
        st.setInt(5, ub.getValorMulta());
        st.execute();
        st.close();

    }

    public static void addFone(UsuarioBean ub, Connection con) throws SQLException{
        PreparedStatement st;
        Statement st2;
        st2 = con.createStatement();

        String sql = "select id_usuario, nome from usuario where id_usuario in (select max(id_usuario) from usuario);";
        ResultSet result = st2.executeQuery(sql);
        UsuarioBean ub2 = new UsuarioBean();
        while(result.next()) {
            ub2.setIdUsuario(result.getInt(1));
        }


        st = con.prepareStatement("INSERT INTO telefones(fone, id_usuario)" + "VALUES (?,?)");
        st.setInt(1, ub.getTelefones().get(0));
        st.setInt(2, ub2.getIdUsuario());
        st.execute();
        st.close();

    }

    public static void addFoneExtra(UsuarioBean ub, int telefone, Connection con) throws SQLException {
        PreparedStatement st;

        st = con.prepareStatement("INSERT INTO telefones(fone, id_usuario)" + "VALUES (?,?)");
        st.setInt(1,telefone);
        st.setInt(2,ub.getIdUsuario());
        st.execute();
        st.close();

}

    public static HashSet listAll(Connection con) throws SQLException{
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_usuario, nome, endereco, categoria, qnt_livros, valor_multa FROM usuario";
        ResultSet result = st.executeQuery(sql);


        while(result.next()){
            list.add(new UsuarioBean(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getInt(5),result.getInt(6)));
        }
        return list;
    }


}
