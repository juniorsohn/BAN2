package biblioteca.controller;

import biblioteca.model.RegistroModel;
import biblioteca.model.UsuarioModel;
import biblioteca.view.RegistroBean;
import biblioteca.view.UsuarioBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;

public class RegistroController {

    public static void renovaLivro(UsuarioBean ub, Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha um livro emprestado para renovar!");
        listarRegistros(con);
        int escolha_registro = sc.nextInt();
        RegistroBean registro_escolhido = RegistroModel.escolheRegistro(escolha_registro,con);
        if(ub.getIdUsuario() != registro_escolhido.getId_usuario()){
            System.out.println("Apenas renove um livro que você emprestou!");
            return;
        }
        RegistroModel.renovaLivro(registro_escolhido,ub,con);

    }

    public static void reservaLivro(UsuarioBean ub, Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha um livro para reservar!");
        listarRegistros(con);
        int escolha_registro = sc.nextInt();
        RegistroBean registro_escolhido = RegistroModel.escolheRegistro(escolha_registro,con);
        if(registro_escolhido.isReservado()){
            System.out.println("O livro em questão já está reservado!");
            return;
        }
        RegistroModel.reservaLivro(registro_escolhido,ub,con);

    }

    public static void listarRegistros(Connection con) throws SQLException{
        HashSet all = RegistroModel.listAll(con);
        for (RegistroBean registroBean : (Iterable<RegistroBean>) all) {
            System.out.println(registroBean);
        }
    }


}
