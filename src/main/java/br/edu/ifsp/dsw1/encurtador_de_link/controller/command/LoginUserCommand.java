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
		
		if (user.verify(password)) {
			var session = request.getSession(true);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(3600);
			System.out.println("Verificou");
			return "logged.do?action=home";
		}
		return "front.do?action=home&msg=Não foi possível entrar na sua conta";
	}
	
}
