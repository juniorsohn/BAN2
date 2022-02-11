package biblioteca.model;

import biblioteca.view.LivroBean;
import biblioteca.view.RegistroBean;
import biblioteca.view.UsuarioBean;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;

public class LivroModel {

    public static void create(LivroBean lb, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO livro(nro_livro, titulo, isbn, editora, colecao)" + "VALUES (DEFAULT,?,?,?,?)");
        st.setString(1, lb.getTitulo());
        st.setInt(2, lb.getISBN());
        st.setString(3, lb.getEditora());
        st.setString(4, lb.getColecao());
        st.execute();
        st.close();


    }

    public static void addAutor(LivroBean lb, Connection con) throws SQLException {
        PreparedStatement st;
        Statement st2 = con.createStatement();
        String sql = "Select nro_livro, titulo, isbn, editora, colecao from livro where nro_livro in (select max(nro_livro) from livro)";
        ResultSet result = st2.executeQuery(sql);
        LivroBean lb_aux = new LivroBean();

        while (result.next()) {
            lb_aux.setNro_livro(result.getInt(1));
        }

        st = con.prepareStatement("INSERT INTO autores(nome, nro_livro) " + "VALUES (?,?)");
        st.setString(1, lb.getAutores().get(0));
        st.setInt(2, lb_aux.getNro_livro());
        st.execute();
        st.close();
    }

    public static LivroBean escolheLivro(int escolha_livro, Connection con) throws SQLException {
        LivroBean lb = new LivroBean();
        Statement st;
        st = con.createStatement();
        String sql = "Select nro_livro, titulo, isbn, editora, colecao from livro where nro_livro = "+escolha_livro+";";
        ResultSet result = st.executeQuery(sql);
        while(result.next()){
            lb = new LivroBean(result.getInt(1),result.getString(2),result.getInt(3),result.getString(4),result.getString(5));
        }


        return lb;
    }

    public static void addEmprestimo(LivroBean lb, UsuarioBean ub, Date data, Connection con) throws SQLException{

        if(lb.getColecao() == "reserva"){
            System.out.println("Um livro da coleção de reserva não pode ser emprestado!");
            return;
        }

        PreparedStatement st;
        Statement st_checagem;
        st = con.prepareStatement("INSERT INTO registroemprestimo(data, data_devolucao, devolvido, reservado, renovado, id_usuario, nro_livro) "
        +"VALUES (?,?,?,?,?,?,?)");


        st.setDate(1, data);
        st.setDate(2,null);
        st.setDate(3, null);
        st.setBoolean(4, false);
        st.setInt(5, 0);
        st.setInt(6, ub.getIdUsuario());
        st.setInt(7,lb.getNro_livro());
        st.execute();
        st.close();

        st_checagem = con.createStatement();
        String sql = "Select checa_categoria("+ub.getIdUsuario()+");";
        ResultSet result = st_checagem.executeQuery(sql);
        while(result.next()){
            System.out.println("Checagem realizada!");
        }



        // fazer rotina server-side pra verificar categoria e incrementar qnt_livros || FEITO! checa_categoria();
    }

    public static void addAutorExtra(LivroBean lb, String autor, Connection con) throws SQLException {
        PreparedStatement st;

        st = con.prepareStatement("INSERT INTO autores(nome, nro_livro) " + "VALUES (?,?)");
        st.setString(1,autor);
        st.setInt(2,lb.getNro_livro());
        st.execute();
        st.close();

    }


    public static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT nro_livro, titulo, isbn, editora, colecao from livro";
        ResultSet result = st.executeQuery(sql);


        while (result.next()) {
            list.add(new LivroBean(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5)));
        }

        return list;
    }



}
