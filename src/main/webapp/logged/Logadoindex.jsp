<%--
  Created by IntelliJ IDEA.
  User: junior
  Date: 05/02/25
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/includes/head.html"/>
<body>
<jsp:include page="/includes/navbarLogado.jsp"/>
<hr>
<%String link = (String) request.getAttribute("link");%>

<form action="front.do?action=encurtar" method="post">
    <input type="text" name="textLink"
           placeholder="Digite o link" required="required">
    <button type="submit">Encurtar</button>
</form>

<% if (link != null ) {%>
<h1><a href="<%="http://localhost:8080/arqdsw1_encurtador_links/curto/"+link %>">curto/<%=link %></a></h1>
<%}%>
</body>
</html>
