package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.UserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var dao = new UserDaoFactory().factory();
		
		var name = request.getParameter("name");
		var password = request.getParameter("password");
		
		var user = dao.getByName(name);
		
		if (user != null) {
		
			if (user.verify(password)) { // verifica se a senha passada pelo usuário (criptografando-a) é a mesma que está armazenada seu usuário, que foi recebido pelo banco de dados sem ter sua senha criptografada novamente
				var session = request.getSession(true);
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(3600);
				return "logged.do?action=home";
			}
		}
		request.setAttribute("msg", "Não foi possível entrar na sua conta");
		return "front.do?action=home";
		
	}
	
}
