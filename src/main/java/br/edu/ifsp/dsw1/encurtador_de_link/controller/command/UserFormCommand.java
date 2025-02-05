package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserFormCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean login = Boolean.parseBoolean(request.getParameter("login"));
        request.setAttribute("login", login);

        return "/formUser.jsp";
    }
}
