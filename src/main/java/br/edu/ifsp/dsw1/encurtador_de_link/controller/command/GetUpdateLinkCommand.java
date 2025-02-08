package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetUpdateLinkCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var short_link = request.getAttribute("short_link");
		
		if (short_link != null) {
			request.setAttribute("short_link", short_link);
		}
			
		return "/logged/updateLink.jsp";
	}

}
