package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;

public interface UserDao {
	boolean insert(User user);
	boolean delete(User user);
	User getByName(String name);
}
