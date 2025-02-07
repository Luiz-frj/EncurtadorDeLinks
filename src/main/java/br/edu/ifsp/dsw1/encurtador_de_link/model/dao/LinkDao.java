package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;

public interface LinkDao {
	boolean insert(Link link, String user_name, int tries);
	boolean update(Link link, Link newLink);
	boolean delete(Link link);
	List<Link> get_by_user_name(String name);
	Link get_by_short(String short_link);
	Link get_by_link(String link_string, String user_name);
	Link get_by_link_no_user(String link_string);
}
