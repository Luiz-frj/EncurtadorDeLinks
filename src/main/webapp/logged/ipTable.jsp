<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Encurtador de Link</title>
    <link rel="stylesheet" href="../css/styles.css">
  </head>

  <body class="d-flex justify-content-center align-items-center vh-100 bg-light">
    <jsp:include page="/includes/navbarLogged.jsp"/>
    <div class="container text-center">
      <input type="text" class="form-control bg-dark text-white mb-3" placeholder="Pesquisar...">

      <table class="table table-dark table-bordered text-white">
        <thead>
        <tr>
          <th>IP</th>
          <th>LINK ORIGINAL</th>
          <th>LINK ENCURTADO</th>
          <th>ACESSOS</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>192.168.0.1</td>
          <td>http://exemplo.com/abc</td>
          <td>http://short.ly/xyz</td>
          <td>15</td>
        </tr>
        <tr>
          <td>192.168.0.2</td>
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