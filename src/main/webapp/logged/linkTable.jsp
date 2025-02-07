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

    <div class="container text-center">

      <table class="table table-dark table-bordered text-white">
        <thead>
        <tr>
          <th>LINK ORIGINAL</th>
          <th>LINK ENCURTADO</th>
          <th>ACESSOS</th>
          <th>IP'S DE ACESSO</th>
          <th>ALTERAR</th>
          <th>DELETAR</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>http://exemplo.com/abc</td>
          <td>http://short.ly/xyz</td>
          <td>15</td>
          <th><button><a href="logged.do?action=getIpTable&short_link=<%%>">VERIFICAR</a></button></th>
          <td><button><a href="logged.do?action=getUpdateLink&short_link=<%%>">ALTERAR</a></button></td>
          <th><button><a href="logged.do?action=deleteLink&short_link=<%%>">DELETAR</a></button></th>
        </tr>
        <tr>
          <td>http://exemplo.com/123</td>
          <td>http://short.ly/789</td>
          <td>8</td>
          <th><button><a href="logged.do?action=getIpTable&short_link=<%%>">VERIFICAR</a></button></th>
          <td><button><a href="logged.do?action=getUpdateLink&short_link=<%%>">ALTERAR</a></button></td>
          <th><button><a href="logged.do?action=deleteLink&short_link=<%%>">DELETAR</a></button></th>
        </tr>
        </tbody>
      </table>
      
      <button class="btn btn-danger rounded-pill btn-lg"><a href="logged.do?action=home">VOLTAR</a></button>
    </div>

  </body>
</html>