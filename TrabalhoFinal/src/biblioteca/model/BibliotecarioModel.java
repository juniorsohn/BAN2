package biblioteca.model;

import biblioteca.view.BibliotecarioBean;
import biblioteca.view.FuncionarioBean;
import biblioteca.view.UsuarioBean;

import java.sql.*;
import java.util.HashSet;

public class BibliotecarioModel{
    public static void create(FuncionarioBean fb, Connection con) throws SQLException {

        try{
            PreparedStatement st;


            Statement st2;
            st2 = con.createStatement();

            String sql = "select id_funcionario, nome from funcionario where id_funcionario in (select max(id_funcionario) from funcionario);";
            ResultSet result = st2.executeQuery(sql);
            FuncionarioBean fb2 = new FuncionarioBean();
            while(result.next()) {
                fb2.setId_funcionario(result.getInt(1));
                fb2.setNome(result.getString(2));
            }

            st = con.prepareStatement("INSERT INTO bibliotecario (cod_supervisor, id_funcionario,nome)" + "VALUES (DEFAULT,?,?)");
            st.setInt(1,fb2.getId_funcionario());
            st.setString(2,fb2.getNome());
            st.execute();
            st.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static HashSet listAll(Connection con) throws SQLException{
    Statement st;
    HashSet list = new HashSet();
    st = con.createStatement();
    String sql = "SELECT b.id_funcionario, b.nome, cpf, cod_supervisor FROM funcionario f JOIN bibliotecario b ON f.id_funcionario = b.id_funcionario;";
    ResultSet result = st.executeQuery(sql);


        while(result.next()) {
            list.add(new BibliotecarioBean(result.getInt(4),result.getInt(1),result.getString(2)));
        }
            return list;
    }
}
