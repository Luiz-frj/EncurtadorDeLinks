<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) { %>
                <p><%=msg%></p>
            <%}
        %>
        <form action="front.do?action=loginUser" method="post">
            <label for="name">Nome</label>
            <input type="text" id="name" name="name" placeholder="Digite seu nome" required="required">

            <label for="password">Senha</label>
            <input type="password" id="password" name="password" placeholder="Digite sua senha" required="required">

            <button type="submit">Login</button>
        </form>
    </body>
</html>