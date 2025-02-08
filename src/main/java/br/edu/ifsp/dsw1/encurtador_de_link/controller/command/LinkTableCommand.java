package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.AcessDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;

public class LinkTableCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var link_dao = new LinkDaoFactory().factory();
		var access_dao = new AcessDaoFactory().factory();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
        	var user = (User) session.getAttribute("user");
        	
        	List<Link> link_list = link_dao.get_by_user_name(user.getName());
        	
        	HashMap<Access, Integer> access_map = access_dao.get_short_access_count_by_user(user.getName());
        	
        	request.setAttribute("link_list", link_list);
        	
        	request.setAttribute("access_map", access_map);
        }
		
		return "/logged/linkTable.jsp";
	}
}
