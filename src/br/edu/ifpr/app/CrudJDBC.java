package br.edu.ifpr.app;

import br.edu.ifpr.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class
CrudJDBC {

    private Connection connection;

    public CrudJDBC(Connection connection){
        this.connection = connection;
    }

    public void insert(Contato contato) throws SQLException {

        // cria um	preparedStatement
        String	sql	= "insert into contatos" +
                "(nome,email,endereco,dataNascimento)" +
                "values	(?,?,?,?)";

        PreparedStatement stmt = connection.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, "Caelum");
        stmt.setString(2, "contato@caelum.com.br");
        stmt.setString(3, "R.	Vergueiro	3185	cj57");
        stmt.setDate(4,	new	java.sql.Date(Calendar.getInstance().getTimeInMillis()));

        // executa
        stmt.execute();
        stmt.close();
        System.out.println("Gravado!");
        connection.close();
    }
}
