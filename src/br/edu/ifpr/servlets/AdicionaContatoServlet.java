package br.edu.ifpr.servlets;

import br.edu.ifpr.dao.ContatoDAO;
import br.edu.ifpr.exceptions.DAOException;
import br.edu.ifpr.models.Contato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/saveContact")
public class AdicionaContatoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log("log: inicializando a Servlet");
        super.init();
    }

    @Override
    public void destroy() {
        log("log: destruindo a Servlet");
        super.destroy();
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Nome por post: " + request.getParameter("nome"));
    }
    */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        try {

            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);

            Contato contato = new Contato();
            contato.setNome(request.getParameter("nome"));
            contato.setEmail(request.getParameter("email"));
            contato.setEndereco(request.getParameter("endereco"));
            contato.setDataNascimento(dataNascimento);

            // salva o contato
            ContatoDAO dao = new ContatoDAO();
            dao.create(contato);

            out.println("Contato " + contato.getNome() + " adicionado com sucesso");

        } catch	(ParseException | DAOException e)	{
            out.println("Erro	de	conversão	da	data");
            return;	//para	a	execução	do	método
        }
    }
}