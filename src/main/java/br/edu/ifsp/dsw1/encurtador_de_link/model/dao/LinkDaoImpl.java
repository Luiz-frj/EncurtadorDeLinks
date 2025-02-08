package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;

class LinkDaoImpl implements LinkDao {
	private static final String INSERT = "INSERT INTO tb_links(link, short_link, user_name) VALUES (?,?,?)";
	private static final String DELETE = "DELETE FROM tb_links WHERE short_link = ? AND user_name = ?";
	private static final String UPDATE = "UPDATE tb_links SET link = ?, short_link = ? WHERE short_link = ? AND user_name = ?";
	private static final String UPDATE_LINK_ONLY = "UPDATE tb_links SET link = ? WHERE short_link = ?";
	private static final String GET_ALL_BY_USER_NAME = "SELECT * FROM tb_links WHERE user_name = ?";
	private static final String GET_BY_SHORT = "SELECT * FROM tb_links WHERE short_link = ?";
	private static final String GET_BY_LINK = "SELECT * FROM tb_links WHERE link = ? AND user_name = ?";
	private static final String GET_BY_LINK_NO_USER = "SELECT * FROM tb_links WHERE link = ?";

	@Override
	public boolean insert(Link link, String user_name, int tries) {
		System.out.println("Inserting: " + link.getLink() + " | " + link.getShortLink());
		int rows = 0;
		if (tries > 0) {
			if(link != null) {
				try(var connection = DatabaseConnection.getConnection();
					var statement = connection.prepareStatement(INSERT)){
					
					statement.setString(1, link.getLink());
					statement.setString(2, link.getShortLink());
					statement.setString(3, user_name);
					
					rows = statement.executeUpdate();
					
				} catch(SQLException e) {
					if (e instanceof SQLIntegrityConstraintViolationException) {
						
						link.change_short_link();
						
						insert(link, user_name, tries--);
					} else {
						e.printStackTrace();
					}
				}
			}
		}
		return rows > 0;
	}

	@Override
	public boolean update(Link link, Link newLink) {
		System.out.println("Executing Update: " + UPDATE + " with values: "
			    + newLink.getLink() + ", " + newLink.getShortLink() + ", " + link.getShortLink());
		int rows = 0;
		if(link != null && newLink != null) {
			try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(UPDATE)){
				
				statement.setString(1, newLink.getLink());
				statement.setString(2, newLink.getShortLink());
				statement.setString(3, link.getShortLink());
				statement.setString(4, link.getUserName());
				
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
				
				statement.setString(1, link.getShortLink());
				statement.setString(2, link.getUserName());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public List<Link> get_by_user_name(String name) {
		List<Link> list = new ArrayList<>();
		try {
			var connection = DatabaseConnection.getConnection();
			
			var statement = connection.prepareStatement(GET_ALL_BY_USER_NAME);
			
			statement.setString(1, name);
			var result = statement.executeQuery();
			
			while(result.next()) {
				var link = new Link(result.getString("short_link"), result.getString("link"), name);
				list.add(link);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Link get_by_short(String short_link) {
		Link link = null;
		try {
			var connection = DatabaseConnection.getConnection();
			
			var statement = connection.prepareStatement(GET_BY_SHORT);
			
			statement.setString(1, short_link);
			var result = statement.executeQuery();
			
			while(result.next()) {
				link = new Link(short_link, result.getString("link"), result.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return link;
	}

	@Override
	public Link get_by_link(String link_string, String user_name) {
		Link link = null;
		try {
			var connection = DatabaseConnection.getConnection();
			
			var statement = connection.prepareStatement(GET_BY_LINK);
			
			statement.setString(1, link_string);
			statement.setString(2, user_name);
			var result = statement.executeQuery();
			
			while (result.next()) {
				link = new Link(result.getString("short_link"), link_string);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return link;
	}

	@Override
	public Link get_by_link_no_user(String link_string) {
		Link link = null;
		try {
			var connection = DatabaseConnection.getConnection();
			
			var statement = connection.prepareStatement(GET_BY_LINK_NO_USER);
			
			statement.setString(1, link_string);
			var result = statement.executeQuery();
			
			while (result.next()) {
				link = new Link(result.getString("short_link"), link_string);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return link;
	}


	@Override
	public boolean update_link_only(Link link) {
		System.out.println("Executing Update: " + UPDATE + " with value: "
			    + link);
		int rows = 0;
		if(link != null && link != null) {
			try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(UPDATE_LINK_ONLY)){
				
				statement.setString(1, link.getLink());
				statement.setString(2, link.getShortLink());
				
				rows = statement.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}
	
	
}
