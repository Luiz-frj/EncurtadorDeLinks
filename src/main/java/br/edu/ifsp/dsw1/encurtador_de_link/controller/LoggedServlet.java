package br.edu.ifsp.dsw1.encurtador_de_link.controller;

import br.edu.ifsp.dsw1.encurtador_de_link.controller.command.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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

        if("home".equals(action)) {
            command = new LoggedHomeCommand();
        }else if("encurtar".equals(action)) {
            command = new CommandEncurtar();
        }else if("formUser".equals(action)) {
            command = new UserFormCommand();
        }else if("saveUser".equals(action)) {
            command = new SalvaUsuarioCommand();
        }else if("login".equals(action)) {
            command = new LoginCommand();
        }

        String view = command.execute(request, response);
        var dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}

