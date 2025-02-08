package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.AcessDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetIpTableCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var dao = new AcessDaoFactory().factory();
		
		String short_link = request.getParameter("short_link");
		
		if (short_link != null) {
			
			HashMap<Access, Integer> accessMap = dao.get_access_ip_count_by_short(short_link);
		
			if (accessMap != null) {
				request.setAttribute("access_map", accessMap);
			}
		}
		
		
		return "/logged/ipTable.jsp";
	}

}
