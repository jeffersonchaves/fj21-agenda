package br.edu.ifpr.test;

import br.edu.ifpr.exceptions.DAOException;
import br.edu.ifpr.models.Contato;
import br.edu.ifpr.dao.ContatoDAO;

import java.util.Calendar;

public class TestaDAOInsert {

    public static void main(String[] args) throws DAOException {

        ContatoDAO contatoDAO = new ContatoDAO();

        Contato contato	=	new	Contato();
        contato.setNome("Jefferson");
        contato.setEmail("jefferson@ifpr.ed.br");
        contato.setEndereco("R. Vergueiro 3185 cj87");
        contato.setDataNascimento(Calendar.getInstance());
        contatoDAO.create(contato);
    }
}
