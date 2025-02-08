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

public class UpdateLinkCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("msg", "Ocorreu um erro ao alterar o link");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			LinkDao dao = new LinkDaoFactory().factory();
			
			String old_short_link_input = request.getParameter("short_link_old");
			String short_link_input = request.getParameter("short_link");
			String link_input = request.getParameter("link");
			
			User user = (User) session.getAttribute("user");
			
			if (short_link_input != null) {
				if (short_link_input.length() >= 5 && short_link_input.length() <= 12) { // utilizando a mesma lógica de criar um link curto personalizado, caso o identificador esteja no tamanho adequado, o identificador será alterado para o novo, assim como o link longo.
					Link link = dao.get_by_short(old_short_link_input);
					
					if (link != null) {
						Link newlink = new Link(short_link_input, link_input, user.getName());

						if (dao.update(link, newlink)) {
							request.setAttribute("short_link", newlink.getShortLink());
							request.setAttribute("msg", "");
						}
					}
				} else {
					if (short_link_input.isEmpty()) { // se o usuário deixar o identificador vazio, significa que ele pretende deixar o identificador igual, então apenas o link longo será alterado.
						Link link = new Link(old_short_link_input, link_input, user.getName());
						
						if (dao.update_link_only(link)) {
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
