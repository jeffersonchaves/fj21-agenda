<%--
  Created by IntelliJ IDEA.
  User: JEFFERSON
  Date: 08/08/2019
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, br.edu.ifpr.dao.*, br.edu.ifpr.models.*, br.edu.ifpr.utils.BrazilianFormats.* "%>
<%@ page import="br.edu.ifpr.utils.BrazilianFormats" %>

<%
    ContatoDAO dao = new ContatoDAO();
    List<Contato> contatos = dao.getLista();
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
    <div class="container">
        <table class="table">
            <tr>
                <td>nome</td>
                <td>email</td>
                <td>endereço</td>
                <td>data nascimento</td>
            </tr>
            <% for	(Contato contato : contatos	) { %>
            <tr>
                <td><%=contato.getNome()	%></td>
                <td><%=contato.getEmail()	%></td>
                <td><%=contato.getEndereco()	%></td>
                <td><%=BrazilianFormats.date(contato.getDataNascimento().getTime()) %></td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
