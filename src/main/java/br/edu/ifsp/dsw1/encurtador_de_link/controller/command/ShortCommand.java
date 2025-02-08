package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDao;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShortCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LinkDao dao = new LinkDaoFactory().factory();
		
		String link_input = request.getParameter("link");
		
		Link link = dao.get_by_link_no_user(link_input);
		
		if (link != null) {
			request.setAttribute("short_link", link.getShortLink());
		} else {
			link = new Link(link_input);
			
			if (dao.insert(link, null, 7)) { // é inserido um link sem identificador personalizado, e sem usuário vinculado, o insert possuirá 7 tentativas, pois, caso o identificador gerado já exista na tabela, é feito uma nova tentativa agora com o gerador acrescido de um caractér em seu algoritmo, com 7 tentativas chegamos a 12 caractéres, o tamanho máximo.
				request.setAttribute("short_link", link.getShortLink());
			} else {
				request.setAttribute("msg", "Ocorreu um erro ao criar o link");
			}
		}
		
		return "front.do?action=home";
	}

}
