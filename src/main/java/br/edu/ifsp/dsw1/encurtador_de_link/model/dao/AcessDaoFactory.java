package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

public class AcessDaoFactory {
    public AccessDao factory(){
        return  new AccessDaoImpl();
    }
}
