package biblioteca.controller;

import biblioteca.model.AssistenteModel;
import biblioteca.model.BibliotecarioModel;
import biblioteca.model.FuncionarioModel;
import biblioteca.model.UsuarioModel;
import biblioteca.view.BibliotecarioBean;
import biblioteca.view.FuncionarioBean;
import biblioteca.view.UsuarioBean;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Scanner;

public class FuncionarioController {
    public static void createFuncionario(Connection con) throws SQLException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Insira os dados para a criacao de um novo Funcionario.\n nome: ");
            String nome = sc.nextLine();
            sc.nextLine();
            System.out.println("\nAgora seu numero de cpf: ");
            int cpf = sc.nextInt();
            sc.nextLine();
            System.out.println("O funcionario é um bibliotecario ou um assistente?\n1 - Bibliotecario, 2 - Assistente");
            int eh_bibliotecario = sc.nextInt();
            FuncionarioBean fb = new FuncionarioBean(0, nome, cpf);
            sc.nextLine();

            if (eh_bibliotecario == 1) {
                FuncionarioModel.create(fb, con);
                BibliotecarioModel.create(fb, con);
                return;

            } else if (eh_bibliotecario == 2) {
                FuncionarioModel.create(fb, con);
                System.out.println("Defina o supervisor deste assistente: ");
                BibliotecarioController.listarFuncionarios(con);
                int escolha = sc.nextInt();
                AssistenteModel.create(fb, con, escolha);

            } else {
                System.out.println("Entre com um valor válido para funcionário ou assistente");
                return;
            }

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void listarFuncionarios(Connection con) throws SQLException{
        HashSet all = FuncionarioModel.listAll(con);
        for (FuncionarioBean fb : (Iterable<FuncionarioBean>) all) {
            System.out.println(fb);
        }
    }

}
