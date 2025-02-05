package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

public class UserDaoFactory {
	public UserDao factory() {
		return new UserDaoImpl();
	}
}
