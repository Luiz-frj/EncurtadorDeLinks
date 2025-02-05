<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/includes/head.html"/>
    <body>
        <% boolean login = (Boolean) request.getAttribute("login"); %>
        <jsp:include page="/includes/navbar.jsp"/>
        <hr>
        <%if(!login){ %>
        <form action="front.do?action=saveUser" method="post">
            <label for="login">Usuário</label>
            <input type="text" id="login" name="textLogin"
                   placeholder="Digite o nome de usuário que deseja." required="required">

            <label for="password">Senha</label>
            <input type="password" id="password" name="textPassword"
                   placeholder="Digite a senha segura." required="required">

            <button type="submit">Cadastrar</button>
                <%}else{ %>
            <form action="front.do?action=login" method="post">
                <label for="login">Usuário</label>
                <input type="text" id="login" name="textLogin"
                       placeholder="Digite o nome de usuário." required="required">

                <label for="password">Senha</label>
                <input type="password" id="password" name="textPassword"
                       placeholder="Digite a senha." required="required">

                <button type="submit">Login</button>
                <%} %>
            </form>
    </body>
</html>

