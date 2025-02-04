package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;

public class LinkDaoImpl implements LinkDao {
	private static final String INSERT = "INSERT INTO tb_links(link, short_link, user_name) VALUES (?,?,?)";
	private static final String DELETE = "DELETE FROM tb_links WHERE user_name = ? AND link = ?";
	private static final String UPDATE = "UPDATE tb_links SET link = ?, short_link = ? WHERE link = ?";
	private static final String GET_BY_NAME = "SELECT * FROM tb_links WHERE name = ?";
	private static final String GET_ALL = "SELECT * FROM tb_links";

	@Override
	public boolean insert(Link link) {
		int rows = 0;
		if(link != null) {
			try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, link.getLink());
				statement.setString(2, link.getShortLink());
				statement.setString(3, link.getUser().getName());
				
				rows = statement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public boolean update(Link link, Link newLink) {
		int rows = 0;
		if(link != null && newLink != null) {
			try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(UPDATE)){
				
				statement.setString(1, newLink.getLink());
				statement.setString(2, newLink.getShortLink());
				statement.setString(3, link.getLink());
				
				rows = statement.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public boolean delete(Link link) {
		int rows = 0;
		if (link != null) {
			try( var connection = DatabaseConnection.getConnection();
				 var statement = connection.prepareStatement(DELETE)){
				
				statement.setString(1, link.getLink());
				statement.setString(2, link.getUser().getName());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

}
