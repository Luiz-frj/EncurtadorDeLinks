<%@ page import="br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Encurtador de Link</title>
	    <link rel="stylesheet" href="../css/styles.css">
	</head>

  <body class="d-flex justify-content-center align-items-center vh-100 bg-light">

    <div class="container text-center">
    
    <%
		List<Link> link_list = (List<Link>) request.getAttribute("link_list");
    
    	if (link_list != null) {
	%>

      <table class="table table-dark table-bordered text-white">
        <thead>
        <tr>
          <th>LINK ORIGINAL</th>
          <th>LINK ENCURTADO</th>
          <th>ACESSOS</th>
          <th>IP'S DE ACESSO</th>
          <th>ALTERAR</th>
          <th>DELETAR</th>
        </tr>
        </thead>
        <tbody>
        <%
        	for (Link i : link_list) {
      
        %>
        <tr>
          <td><%=i.getLink()%></td>
          <td>http://localhost:8888/encurtador_link_2/short/<%=i.getShortLink()%></td>
          <td>0</td>
          <th><button><a href="logged.do?action=getIpTable&short_link=<%=i.getShortLink()%>">VERIFICAR</a></button></th>
          <td><button><a href="logged.do?action=getUpdateLink&short_link=<%=i.getShortLink()%>">ALTERAR</a></button></td>
          <th><button><a href="logged.do?action=deleteLink&short_link=<%=i.getShortLink()%>">DELETAR</a></button></th>
        </tr>
        <%} 
        } else { %>
        	<p>Ocorreu um erro ao receber os links do usuário</p>
        <%} %>
        </tbody>
      </table>
      
      <button class="btn btn-danger rounded-pill btn-lg"><a href="logged.do?action=home">VOLTAR</a></button>
    </div>

  </body>
</html>