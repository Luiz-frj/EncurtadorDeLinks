<%--
  Created by IntelliJ IDEA.
  User: junior
  Date: 05/02/25
  Time: 14:16
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
	</head>
	<body>
		<jsp:include page="/includes/navbar.jsp"/>

		<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) { %>
				<p><%=msg%></p>
			<%}
		%>

		<form action="front.do?action=signUser" method="post">
			<label for="name">Nome</label>
			<input type="text" id="name" name="name" placeholder="Digite seu nome." required="required">

			<label for="password">Senha</label>
			<input type="password" id="password" name="password" placeholder="Escolha uma senha" required="required">

			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>