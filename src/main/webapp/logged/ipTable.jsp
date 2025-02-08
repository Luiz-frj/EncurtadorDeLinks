<%@ page import="java.util.HashMap" %>
<%@ page import="br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Encurtador de Link</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="shortcut icon" href="images/encurtaLink.png" type="image/x-icon">
  </head>

  <body class="d-flex justify-content-center align-items-center vh-100 bg-light">
    <jsp:include page="/includes/navbarLogged.jsp"/>
    <div class="container text-center">
    
     <%
    	HashMap<Access, Integer> access_map = (HashMap<Access, Integer>) request.getAttribute("access_map");
    
    	if (access_map != null) {
	%>

      <table class="table table-dark table-bordered text-white">
        <thead>
        <tr>
          <th>IP</th>
          <th>LINK ENCURTADO</th>
          <th>ACESSOS</th>
        </tr>
        </thead>
        <tbody>
        <%
    	for (Access ac : access_map.keySet()) {
        %>
        <tr>
       	  <td><%=ac.getIp()%></td>
          <td>http://localhost:8888/encurtador_link_2/short/<%=ac.getLink()%></td>
          <td><%=access_map.get(ac) %></td>
        </tr>
        <%} %>
        </tbody>
      </table>
      <%} else { %>
      <p>Ocorreu um erro ao receber os links do usuário</p>
      <%} %>
      <button class="btn btn-danger rounded-pill btn-lg">VOLTAR</button>
    </div>
  </body>
</html>