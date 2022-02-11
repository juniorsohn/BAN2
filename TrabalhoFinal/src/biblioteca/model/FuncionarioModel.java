package biblioteca.model;

import biblioteca.view.FuncionarioBean;
import biblioteca.view.UsuarioBean;

import java.sql.*;
import java.util.HashSet;

public class FuncionarioModel {
    public static void create(FuncionarioBean fb, Connection con) throws SQLException {
        PreparedStatement st;

        st = con.prepareStatement("INSERT INTO funcionario (id_funcionario, nome, cpf)" + "VALUES (DEFAULT,?,?)");
        st.setString(1, fb.getNome());
        st.setInt(2, fb.getCpf());
        st.execute();
        st.close();

    }


    public static HashSet listAll(Connection con) throws SQLException{
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_funcionario, nome, cpf from funcionario";
        ResultSet result = st.executeQuery(sql);


        while(result.next()) {
            list.add(new FuncionarioBean(result.getInt(1), result.getString(2), result.getInt(3)));
        }
            return list;
    }
}
