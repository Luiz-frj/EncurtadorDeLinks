package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDao;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggedShortCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			String short_link_input = request.getParameter("short_link");
			LinkDao dao = new LinkDaoFactory().factory();
			
			String link_input = request.getParameter("link");
			
			User user = (User) session.getAttribute("user");
			
			request.setAttribute("msg", "Ocorreu um erro ao criar o link");
			
			if (short_link_input != null) {
				if (short_link_input.length() >= 5 && short_link_input.length() <= 12) {
					Link link = dao.get_by_short(short_link_input);
					
					if (link != null) {
						request.setAttribute("msg", "Esse link encurtado já existe");
					} else {
						link = new Link(short_link_input, link_input, user.getName());
						
						if (dao.insert(link, user.getName(), 2)) {
							request.setAttribute("short_link", link.getShortLink());
							request.setAttribute("msg", "");
						}
					}
				} else {
					if (short_link_input.isEmpty()) {
						Link link = new Link(link_input, user);
						
						if (dao.insert(link, user.getName(), 5)) {
							request.setAttribute("short_link", link.getShortLink());
							request.setAttribute("msg", "");
						}
					} else {
						request.setAttribute("msg", "O link encurtado precisa ter um tamanho maior do 5 e menor do que 12 caractéres");
					}
				}
			}
		}
		
		return "logged.do?action=home";
	}

}
