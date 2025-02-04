package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;

public interface LinkDao {
	boolean insert(Link link);
	boolean update(Link link, Link newLink);
	boolean delete(Link link);
}
