package biblioteca.controller;

import biblioteca.model.BibliotecarioModel;
import biblioteca.model.FuncionarioModel;
import biblioteca.view.BibliotecarioBean;
import biblioteca.view.FuncionarioBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

public class BibliotecarioController {


    public static void listarFuncionarios(Connection con) throws SQLException {
        HashSet all = BibliotecarioModel.listAll(con);
        for (BibliotecarioBean bibliotecarioBean: (Iterable<BibliotecarioBean>) all) {
            System.out.println(bibliotecarioBean);
        }
    }


}
