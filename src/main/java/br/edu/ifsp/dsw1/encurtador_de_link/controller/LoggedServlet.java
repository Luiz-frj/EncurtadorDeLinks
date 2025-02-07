package br.edu.ifsp.dsw1.encurtador_de_link.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.controller.command.*;

@WebServlet("/logged.do")
public class LoggedServlet extends HttpServlet {
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
        
        if("logoff".equals(action)) {
			command = new LogoffCommand();
		} else if("short".equals(action)) {
			command = new LoggedShortCommand();
		} else if("tableLinks".equals(action)) {
			
		} else {
			command = new LoggedHomeCommand();
		}

        String view = command.execute(request, response);
        var dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}