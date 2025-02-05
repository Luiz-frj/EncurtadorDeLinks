package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var login = request.getParameter("textLogin");
        var senha = request.getParameter("textPassword");

        var dao = new UserDaoFactory().factory();
        var user = dao.findByLogin(login);

        var authorized = User.authenticate(user, login, senha);

        String view;

        if(authorized) {
            var session = request.getSession(true);
            session.setAttribute("user_id", user);
            session.setMaxInactiveInterval(24*60*60);
            view = "user.do?action=logged";
        }else {
            view = "front.do?action=home";
        }
        return view;
    }
}
