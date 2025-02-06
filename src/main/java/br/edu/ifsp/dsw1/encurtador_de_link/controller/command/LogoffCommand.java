package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoffCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		return "front.do?action=home";
	}

}
