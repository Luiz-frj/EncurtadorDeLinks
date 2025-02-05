<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/includes/head.html"/>

    <body class="d-flex justify-content-center align-items-center vh-100 bg-light">
        <jsp:include page="/includes/navbarLogado.jsp"/>

        <div class="container text-center">
            <button class="btn btn-dark rounded-pill btn-lg mb-3">LOGIN</button><br>
            <button class="btn btn-dark rounded-pill btn-lg mb-3">TABELA</button><br>

            <!-- Campo de entrada para o link -->
            <input type="text" class="form-control bg-dark text-white text-center mb-3" placeholder="Insira o link aqui">

            <button class="btn btn-warning rounded-pill btn-lg">ENCURTAR LINK</button>

            <%
            String link = (String) request.getAttribute("link");
            if (link != null ) {%>
            <h1><a href="<%="http://localhost:8080/arqdsw1_encurtador_links/curto/"+link %>">curto/<%=link %></a></h1>
            <%}%>
        </div>

    </body>
</html>
