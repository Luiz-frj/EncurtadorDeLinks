package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDao;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", "Ocorreu um erro ao deletar o link");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			LinkDao dao = new LinkDaoFactory().factory();
			
			String short_link_input = request.getParameter("short_link");
			
			User user = (User) session.getAttribute("user");
			
			if (short_link_input != null) {
				Link link = dao.get_by_short(short_link_input);
				
				if (link != null) {
					if (dao.delete(link)) {
						request.setAttribute("msg", "Link deletado com sucesso");
					}
				}
			}
		}
		
		return "logged.do?action=home";
	}

}
