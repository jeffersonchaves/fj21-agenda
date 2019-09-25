package br.edu.ifpr.test;

import br.edu.ifpr.dao.ContatoDAO;
import br.edu.ifpr.exceptions.DAOException;
import br.edu.ifpr.models.Contato;

import java.util.Calendar;

public class TestaDAOUpdate {

    public static void main(String[] args) throws DAOException {

        ContatoDAO contatoDAO = new ContatoDAO();

        Contato contato	= new Contato();
        contato.setId(2L);
        contato.setNome("Jefferson Chaves");
        contato.setEmail("jefferson.chaves@ifpr.ed.br");
        contato.setEndereco("Av. Araucária, 780 - Vila A");
        contato.setDataNascimento(Calendar.getInstance());
        contatoDAO.update(contato);
    }
}
