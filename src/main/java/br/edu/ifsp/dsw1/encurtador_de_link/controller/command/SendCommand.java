package br.edu.ifsp.dsw1.encurtador_de_link.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.AcessDaoFactory;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SendCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var linkdao = new LinkDaoFactory().factory();
		var accessdao = new AcessDaoFactory().factory();
		
		String pathString = request.getRequestURI().substring(request.getContextPath().length());
		Path path = Paths.get(pathString);
		String short_link = path.getName(path.getNameCount() - 1).toString();

		Link link = linkdao.get_by_short(short_link);
		
		if (link != null) {
			String ipAddress = request.getHeader("X-FORWARDED-FOR");  
			if (ipAddress == null || "".equals(ipAddress)) {
				ipAddress = request.getRemoteAddr();
			}
			Access access = new Access(link.getShortLink(), ipAddress);
			
			accessdao.insert(access);
			
			return link.getLink();
		}
		
		request.setAttribute("msg", "Não foi possível encontrar o seu link");
		
		return "front.do?action=home";
	}

}
