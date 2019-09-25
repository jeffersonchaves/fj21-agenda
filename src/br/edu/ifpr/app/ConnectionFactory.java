package br.edu.ifpr.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        System.out.println("Conectando ao banco");
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");

        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}