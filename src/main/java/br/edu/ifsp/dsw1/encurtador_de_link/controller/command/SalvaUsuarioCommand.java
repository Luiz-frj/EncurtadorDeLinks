package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SalvaUsuarioCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var login = request.getParameter("textLogin");
        var senha = request.getParameter("textPassword");

        var dao = new UserDaoFactory().factory();
        var user = new User(login, senha, true);
        var saved = dao.insert(user);

        if(saved) {
            System.out.println("salvou usuário");
        }else {
            System.out.println("não salvou");
        }

        return "front.do?action=home";
    }
}
