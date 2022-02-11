package biblioteca.controller;

import biblioteca.model.LivroModel;
import biblioteca.view.LivroBean;
import biblioteca.view.UsuarioBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class LivroController {
    public static void createLivro(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira os dados para a criacao de um livvro no sistema\n Titulo: ");
        String titulo = sc.nextLine();
        System.out.println("\nSeu numero de ISBN:  ");
        int isbn = sc.nextInt();
        sc.nextLine();
        System.out.println("Seu autor (é possível adicionar mais posteriormente): ");
        List<String> autores = new ArrayList<>();
        autores.add(sc.nextLine()) ;
        System.out.println("Sua editora: ");
        String editora = sc.nextLine();
        System.out.println("E a sua colecao (publica ou reserva): ");
        String colecao = sc.nextLine();

        LivroBean lb = new LivroBean(0,titulo, (ArrayList<String>) autores,isbn,editora,colecao);
        LivroModel.create(lb, con);
        LivroModel.addAutor(lb,con);
    }


    public static void emprestaLivro(UsuarioBean ub, Connection con) throws SQLException{
        Scanner sc = new Scanner(System.in);
       long millis = System.currentTimeMillis();
        java.sql.Date data = new java.sql.Date(millis); // pega a data atual para empréstimo
        System.out.println("Escolha um livro para emprestar!");
        listarLivros(con);
        int escolha_livro = sc.nextInt();
        LivroBean livro_escolhido = LivroModel.escolheLivro(escolha_livro,con);
        if(livro_escolhido.getColecao() == "Reserva" || livro_escolhido.getColecao() == "reserva"){
            System.out.println("Um livro da reserva não pode ser emprestado!");
            return;
        }
        LivroModel.addEmprestimo(livro_escolhido,ub,data,con);

    }
    public static void addAutorExtra(LivroBean lb, Connection con) throws SQLException {
        try{
            Scanner sc = new Scanner(System.in);

        System.out.println("Entre com um autor para ser agregado ao livro: ");
        String autor = sc.nextLine();
        LivroModel.addAutorExtra(lb,autor,con);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Autor adicionado com sucesso!");
    }


    public static void listarLivros(Connection con) throws SQLException{
        HashSet all = LivroModel.listAll(con);
        for (LivroBean livroBean : (Iterable<LivroBean>) all) {
            System.out.println(livroBean);
        }
    }



}
