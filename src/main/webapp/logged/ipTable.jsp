<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link" %>
<%@ page import="br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User" %>
<jsp:include page="/includes/navbarLogado.jsp"/>

<%
  User user = (User) session.getAttribute("user");
  if (user == null) {
    response.sendRedirect("login.jsp");
    return;
  }

  List<Link> links = (List<Link>) request.getAttribute("links");
%>

<div class="container">
  <h2>Meus Links</h2>

  <table class="table table-striped">
    <thead>
    <tr>
      <th>Original</th>
      <th>Encurtado</th>
      <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <%
      if (links != null && !links.isEmpty()) {
        for (Link link : links) {
    %>
    <tr>
      <td><a href="<%= link.getLink() %>" target="_blank"><%= link.getLink() %></a></td>
      <td><a href="r/<%= link.getShortLink() %>" target="_blank"><%= request.getServerName() %>/r/<%= link.getLinkEncurtado() %></a></td>
      <td>
        <form action="FrontServlet" method="post" style="display:inline;">
          <input type="hidden" name="command" value="DeleteLinkCommand">
          <input type="hidden" name="curto" value="<%= link.getShortLink() %>">
          <button type="submit" class="btn btn-danger btn-sm">Excluir</button>
        </form>
        <a href="FrontServlet?command=EditLinkCommand&curto=<%= link.getShortLink() %>" class="btn btn-warning btn-sm">Editar</a>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="3" class="text-center">Nenhum link encontrado.</td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
</div>