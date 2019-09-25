package br.edu.ifpr.test;

import br.edu.ifpr.dao.ContatoDAO;
import br.edu.ifpr.models.Contato;

import java.util.List;

public class TestaLista {

    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();

        List<Contato> contatos = dao.getLista();

        for (Contato contato: contatos) {
            contato.show();
        }

    }
}
