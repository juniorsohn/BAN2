package biblioteca;

import biblioteca.conexao.Conexao;
import biblioteca.controller.FuncionarioController;
import biblioteca.controller.LivroController;
import biblioteca.controller.RegistroController;
import biblioteca.controller.UsuarioController;
import biblioteca.model.LivroModel;
import biblioteca.view.LivroBean;
import biblioteca.view.UsuarioBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        int opcao;
        Conexao c = new Conexao();
        Connection con = c.getConnection();



        do {
            opcao = menu();
            try {
                switch (opcao) {
                    case 1:
                        UsuarioController.createUsuario(con);
                        break;
                    case 2:
                        escolheUsuario(con);
                        break;
                    case 3:
                        FuncionarioController.createFuncionario(con);
                        break;
                    case 4:
                        LivroController.createLivro(con);
                        break;
                    case 5:
                        escolheLivro(con);
                        break;
                    case 6:
                        RegistroController.listarRegistros(con);
                        break;


                    default:
                        System.out.println("Saindo...\n");
                        break;
                }


            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }while(opcao>0 && opcao<7); // lembrar de mudar isso quando tiver o tamanho final do menu

        c.closeConnection();
    }


    /* fazer um menu que permite:
            * empréstimo de um livro para um usuário (Tem que anotar o id_usuário e o nro_livro junto com os campos da tabela
            * as verificações se o usuário em questão pode emprestar livros (chama as funções valida_emprestimo e checa_devolucao)
            * reservar um livro já emprestado por outro usuário
            * renovação do empréstimo do usuário por no máximo 3 vezes
        */

    public static int menu() {
        System.out.println("\nBem vindo ao sistema de gerenciamento de Biblioteca! Para iniciar, Escolha seu usuário ou crie um novo.");
        System.out.println("1: Criar Usuario\n2: Escolher Usuario ja existente\n3: Criar Funcionario\n4: Adicionar Livro\n5: Adicionar Autor para Livro\n6: Mostrar empréstimos\nEscreva qualquer outro numero para sair\n");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void menuUsuario(UsuarioBean ub, Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Adicionar Telefone\n2: Emprestar Livro\n3: Renovar livro\n4: Reservar Livro");

        int escolha_usuario = sc.nextInt();

        switch(escolha_usuario){
            case 1:
                UsuarioController.createFoneExtra(ub,con);
                break;
            case 2:
                LivroController.emprestaLivro(ub,con);
                break;
            case 3:
                RegistroController.renovaLivro(ub,con);
                break;
            case 4:
                RegistroController.reservaLivro(ub,con);
                break;
        }

    }

    private static void escolheLivro(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Statement st;

        st = con.createStatement();
        LivroController.listarLivros(con);
        System.out.println("Escolha um livro: ");
        int escolha_livro = sc.nextInt();
        String sql = "Select nro_livro, titulo, isbn, editora, colecao from livro where nro_livro = "+escolha_livro+";";
        ResultSet result = st.executeQuery(sql);
        LivroBean lb = new LivroBean();
        while(result.next()){
            lb = new LivroBean(result.getInt(1),result.getString(2),result.getInt(3),result.getString(4),result.getString(5));
        }
        LivroController.addAutorExtra(lb,con);

    }


    public static void escolheUsuario(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Statement st;

        st = con.createStatement();
        UsuarioController.listarUsuarios(con);
        System.out.println("Escolha um usuario: ");
        int escolha = sc.nextInt();
        String sql = "SELECT id_usuario, nome, endereco, categoria, qnt_livros, valor_multa FROM usuario WHERE id_usuario = "+escolha+";";
        ResultSet result = st.executeQuery(sql);
        UsuarioBean ub = new UsuarioBean();
        while(result.next()) {
            ub = new UsuarioBean(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getInt(6));
        }

        menuUsuario(ub, con);


    }
}
