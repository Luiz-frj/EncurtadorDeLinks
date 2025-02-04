package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.UserDaoImpl;

public class UserDaoFactory {
	public UserDao factory() {
		return new UserDaoImpl();
	}
}
