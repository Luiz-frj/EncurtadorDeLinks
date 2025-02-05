<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <jsp:include page="/includes/head.html"/>

  <body class="d-flex justify-content-center align-items-center vh-100 bg-light">

    <div class="container text-center">
      <input type="text" class="form-control bg-dark text-white mb-3" placeholder="Pesquisar...">

      <table class="table table-dark table-bordered text-white">
        <thead>
        <tr>
          <th>IP</th>
          <th>USUÁRIO</th>
          <th>LINK ANTIGO</th>
          <th>LINK NOVO</th>
          <th>CLIQUES</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>192.168.0.1</td>
          <td>admin</td>
          <td>http://exemplo.com/abc</td>
          <td>http://short.ly/xyz</td>
          <td>15</td>
        </tr>
        <tr>
          <td>192.168.0.2</td>
          <td>user1</td>
          <td>http://exemplo.com/123</td>
          <td>http://short.ly/789</td>
          <td>8</td>
        </tr>
        </tbody>
      </table>

      <button class="btn btn-warning rounded-pill btn-lg mb-2">PESQUISAR</button><br>
      <button class="btn btn-danger rounded-pill btn-lg">VOLTAR</button>
    </div>

  </body>
</html>
