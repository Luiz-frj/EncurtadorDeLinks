package br.edu.ifsp.dsw1.encurtador_de_link.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.controller.command.*;

@WebServlet("/front.do")
public class FrontServlet_ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = null;
		String action = request.getParameter("action");
		
		if("loginUser".equals(action)) {
			command = new LoginUserCommand();
		} else if("signUser".equals(action)) {
			command = new SignUserCommand();
		} else if("formLoginUser".equals(action)) {
			command = new FormLoginUserCommand();
		} else if("formSignUser".equals(action)) {
			command = new FormSignUserCommand();
		} else if("home".equals(action)) {
			command = new HomeCommand();
		} else if("short".equals(action)) {
			command = new ShortCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
