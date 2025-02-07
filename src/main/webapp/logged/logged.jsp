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
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Encurtador de Link</title>
		<link rel="stylesheet" href="css/styles.css">
		<link rel="shortcut icon" href="images/encurtaLink.png" type="image/x-icon">
	</head>
	<body>
		<jsp:include page="/includes/navbarLogged.jsp"/>

		<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) { %>
				<p><%=msg%></p>
			<%}
		%>

		<form action="logged.do?action=short" method="post">
			<input type="text" name="link" placeholder="Digite o link" required="required">
			<p>Deixe em branco para gerar um link curto aleatório</p>
			<input type="text" name="short_link" placeholder="Digite o link encurtado que deseja">
			<button type="submit">Encurtar</button>
		</form>

		<%
			String short_link = (String) request.getAttribute("short_link");
			if (short_link != null) { %>
				<a href="http://localhost:8080/encurtador_link_2/short/<%=short_link%>">http://localhost:8080/encurtador_link_2/short/<%=short_link%></a>
			<%}
		%>
	</body>
</html>
