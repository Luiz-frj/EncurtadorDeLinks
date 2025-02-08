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
				if (short_link_input.length() >= 5 && short_link_input.length() <= 12) { // caso o identificador inserido esteja dentro dos padrões esperados, é verificado se ele já existe, do contrário é inserido com os valores passados pelo usuário
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
					if (short_link_input.isEmpty()) { // no caso do identificador ser vazio, significa que o usuário deseja que identificador seja gerado automaticamente, logo será utilizado um construtor com apenas link e usuário, fazendo 7 tentativas (caso não será possível inserir, o método é executado novamente, mas com o link 1 caractér totalizadndo 12 caractéres)
						Link link = new Link(link_input, user);
						
						if (dao.insert(link, user.getName(), 7)) {
							request.setAttribute("short_link", link.getShortLink());
							request.setAttribute("msg", "");
						}
					} else { // caso o identificador não seja nem vazio nem possua o tamanho correto, então é deduzido que o usuário forneceu a uma informação errada
						request.setAttribute("msg", "O link encurtado precisa ter um tamanho maior do 5 e menor do que 12 caractéres");
					}
				}
			}
		}
		
		return "logged.do?action=home";
	}

}
