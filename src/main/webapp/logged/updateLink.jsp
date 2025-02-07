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
    <link rel="stylesheet" href="../css/styles.css">
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
	    <label for="link">Link Longo</label>
	    <input type="text" id="link" name="link" placeholder="Coloque o link longo" required="required">
	
		<p>Deixe o link curto em branco para permanecer o mesmo de antes</p>
	    <label for="short_link">Link Curto</label>
	    <input type="password" id="short_link" name="short_link" placeholder="Escolha um código para o link encurtado">
	
	    <button type="submit">Alterar Link</button>
	</form>
</body>
</html>