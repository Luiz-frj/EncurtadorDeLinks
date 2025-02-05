package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.User;

class UserDaoImpl implements UserDao {
	private static final String INSERT = "INSERT INTO tb_users(name, password) VALUES (?,?)";
	private static final String DELETE = "DELETE FROM tb_users WHERE name = ?";
	private static final String GET_BY_NAME = "SELECT * FROM tb_users WHERE name = ?";
	//private static final String GET_ALL = "SELECT * FROM tb_users";
	
	@Override
	public boolean insert(User user) {
		int rows = 0;
		if(user != null) {
			try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, user.getName());
				statement.setString(2, user.getPassword());
				
				rows = statement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}
	@Override
	public boolean delete(User user) {
		int rows = 0;
		if (user != null) {
			try( var connection = DatabaseConnection.getConnection();
				 var statement = connection.prepareStatement(DELETE)){
				
				statement.setString(1, user.getName());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}
	@Override
	public User getByName(String name) {
		User user = null;
		try ( var connection = DatabaseConnection.getConnection();
			var statement = connection.prepareStatement(GET_BY_NAME)) {
			
			statement.setString(1, name);
			var resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getString("name"), resultSet.getString("password"), true);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		} 
			
		return user;
	}
	
}
