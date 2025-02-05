package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

public class LinkDaoFactory {
    public LinkDao factory(){
        return new LinkDaoImpl();
    }
}
