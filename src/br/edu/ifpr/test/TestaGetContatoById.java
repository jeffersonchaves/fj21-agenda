package br.edu.ifpr.test;

import br.edu.ifpr.dao.ContatoDAO;
import br.edu.ifpr.models.Contato;

import java.sql.SQLException;

public class TestaGetContatoById {

    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();

        try {
            Contato contato = dao.getContatoById(3);
            contato.show();
        } catch (NullPointerException | SQLException e){
            System.out.println("cuidado: " + e.getMessage());
        }

    }
}
