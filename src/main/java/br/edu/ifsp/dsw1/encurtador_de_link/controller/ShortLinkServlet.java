package br.edu.ifsp.dsw1.encurtador_de_link.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

import br.edu.ifsp.dsw1.encurtador_de_link.controller.command.Command;
import br.edu.ifsp.dsw1.encurtador_de_link.controller.command.SendCommand;

@WebServlet("/short/*")
public class ShortLinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new SendCommand();
		
		String view = command.execute(request, response);
		
		if (view == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Esse link encurtado não existe");
			return;
		};
		
		if (!urlExists(view)) {
			response.sendError(HttpServletResponse.SC_BAD_GATEWAY, "Não foi possível encontrar esse site");
			return;
		}
        
		response.sendRedirect(view);
	}
	
	private boolean urlExists(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();

            return (responseCode >= 200 && responseCode < 400);
        } catch (IOException e) {
            return false;
        }
    }

}
