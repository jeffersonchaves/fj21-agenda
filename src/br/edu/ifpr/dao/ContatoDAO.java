package br.edu.ifpr.dao;

import br.edu.ifpr.app.ConnectionFactory;
import br.edu.ifpr.exceptions.DAOException;
import br.edu.ifpr.models.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO {

    private Connection connection;

    public ContatoDAO() {
        this.connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão	aberta!");
    }

    public void create(Contato contato) throws DAOException {

        // cria um	preparedStatement
        String	sql	= "insert into contatos" + "(nome,email,endereco,dataNascimento)" + "values	(?,?,?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            // preenche os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e){
            throw new DAOException(e);
        }

        System.out.println("Gravado!");

    }

    public	void update(Contato	contato) {
        String sql	= "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

        try	{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,	contato.getNome());
            stmt.setString(2,	contato.getEmail());
            stmt.setString(3,	contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());

            stmt.execute();
            stmt.close();

        }	catch	(SQLException	e)	{
            throw new	RuntimeException(e);
        }
    }

    public void delte(Contato contato) {

        try	{

            PreparedStatement stmt = this.connection.prepareStatement("delete from contatos where id=?");
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> getLista(){

        List<Contato> contatos = new ArrayList<Contato>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Contato contato = new Contato();
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setEndereco(resultSet.getString("endereco"));

                //Montando a data por meio do setCalendar
                Calendar data = Calendar.getInstance();
                data.setTime(resultSet.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }

            resultSet.close();
            stmt.close();

            return contatos;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Contato getContatoById(int id) throws SQLException {

        Contato contato = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try{

            stmt = connection.prepareStatement("SELECT * FROM contatos WHERE id = ?");
            stmt.setString(1, String.valueOf(id));
            resultSet = stmt.executeQuery();

            if (resultSet.next()){
                contato = new Contato();
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setEndereco(resultSet.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(resultSet.getDate("dataNascimento"));
                contato.setDataNascimento(data);

            } else {
                throw new NullPointerException("registro "+ id +" não encontrado");
            }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na consulta!!!");
            e.printStackTrace();
        } finally {
            resultSet.close();
            stmt.close();
            connection.close();
        }



        return contato;
    }

}