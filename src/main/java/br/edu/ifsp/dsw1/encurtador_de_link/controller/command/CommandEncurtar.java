package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDao;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CommandEncurtar implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var textLink = request.getParameter("textLink");

        LinkDao dao = new LinkDaoFactory().factory();
        Link link = dao.retrieve(textLink);

        if(link==null) {
            link = new Link(textLink);
            boolean saved = dao.create(null, link);
        }

        request.setAttribute("link", link.getShortLink());

        return "front.do?action=home";
    }
}
