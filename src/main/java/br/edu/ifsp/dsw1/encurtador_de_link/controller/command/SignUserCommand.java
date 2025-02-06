package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var dao = new UserDaoFactory().factory();
		
		var name = request.getParameter("name");
		var password = request.getParameter("password");
		
		var user = new User(name, password, true);
		
		if (dao.insert(user)) {
			return "front.do?action=home&msg=O seu usuário foi criado com sucesso";
		}
		
		return "front.do?action=home&msg=Não foi possível criar um novo usuário";
	}
}
