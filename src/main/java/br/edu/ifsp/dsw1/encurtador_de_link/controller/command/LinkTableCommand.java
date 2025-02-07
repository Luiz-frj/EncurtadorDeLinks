package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDaoFactory;

public class LinkTableCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var dao = new LinkDaoFactory().factory();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
        	
        }
		
		//dao.get_by_user_name();
		
		request.setAttribute("links", null);
		
		return "/logged/linkTable.jsp";
	}
}
