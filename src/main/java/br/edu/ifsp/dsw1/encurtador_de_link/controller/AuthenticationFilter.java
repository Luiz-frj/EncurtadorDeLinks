package br.edu.ifsp.dsw1.encurtador_de_link.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns= {"/logged/*", "/logged.do"})
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Recuperando a requisição
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        //Verificando os dados da sessão para verificar validade dela
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            //Caso não seja válida, mandamos o usuário para a index.
            request.setAttribute("msg", "Acesso permitido apenas para usuário logado.");

            var dispatcher = request.getRequestDispatcher("/front.do?action=home");
            dispatcher.forward(request, response);
        }
    }

}
