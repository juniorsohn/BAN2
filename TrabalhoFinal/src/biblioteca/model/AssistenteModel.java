package biblioteca.model;

import biblioteca.view.BibliotecarioBean;
import biblioteca.view.FuncionarioBean;

import java.sql.*;

public class AssistenteModel {
    public static void create(FuncionarioBean fb, Connection con, int escolha) throws SQLException {
        PreparedStatement st;
        Statement st2;
        Statement st3;
        st2 = con.createStatement();
        st3 = con.createStatement();

        String sql = "Select cod_supervisor from bibliotecario where id_funcionario= "+escolha+";";
        String sql2 = "Select id_funcionario from funcionario where id_funcionario in (select max(id_funcionario) from funcionario);";

        ResultSet result = st2.executeQuery(sql);
        BibliotecarioBean bb = new BibliotecarioBean();
        while (result.next()){
            bb.setCod_supervisor(result.getInt(1));
        }

        result.close();
        result = st3.executeQuery(sql2);

        while(result.next()){
            bb.setId_funcionario(result.getInt(1));
        }

        st = con.prepareStatement("INSERT INTO assistente(cod_supervisionado, cod_supervisor, id_funcionario)" + "VALUES (DEFAULT,?,?)");
        st.setInt(1,bb.getCod_supervisor());
        st.setInt(2,bb.getId_funcionario());
        st.execute();
        st.close();

    }
}
