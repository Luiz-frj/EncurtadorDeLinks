package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access;

class AccessDaoImpl implements AccessDao {
	private static final String INSERT = "INSERT INTO tb_access(short_link, ip) VALUES (?,?)";
	private static final String GET_SHORT_ACCESS_COUNT_BY_USER = "SELECT short_link, ip, COUNT(*) AS count\r\n"
			+ "FROM tb_access\r\n"
			+ "JOIN tb_links USING (short_link)\r\n"
			+ "WHERE user_name = ?\r\n"
			+ "GROUP BY short_link;";
	private static final String GET_ACCESS_IP_COUNT_BY_SHORT = "SELECT short_link, ip, COUNT(*) AS count\r\n"
			+ "FROM tb_access\r\n"
			+ "WHERE short_link = ?\r\n"
			+ "GROUP BY short_link, ip";
	private static final String GET_ALL_BY_USER = "SELECT *\r\n"
			+ "FROM tb_access a\r\n"
			+ "INNER JOIN tb_links l USING(short_link)\r\n"
			+ "INNER JOIN tb_users u ON u.name = l.user_name\r\n"
			+ "WHERE u.name = ?";

	@Override
	public boolean insert(Access access) {
		int rows = 0;
		if(access != null) {
			try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, access.getLink());
				statement.setString(2, access.getIp());
				
				rows = statement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public List<Access> get_all_by_user(String user_name) {
		List<Access> list = new ArrayList<>();
		try(var connection = DatabaseConnection.getConnection();
			var statement = connection.prepareStatement(GET_ALL_BY_USER)){
			
			statement.setString(1, user_name);
			
			var result = statement.executeQuery();
			
			while(result.next()) {
				Access access = new Access(result.getString("short_link"), result.getString("ip"));
				list.add(access);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public HashMap<Access, Integer> get_access_ip_count_by_short(String short_link) {
		HashMap<Access, Integer> hash = new HashMap<>();
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(GET_ACCESS_IP_COUNT_BY_SHORT)){
				
				statement.setString(1, short_link);
				
				var result = statement.executeQuery();
				
				while(result.next()) {
					Access access = new Access(result.getString("short_link"), result.getString("ip"));
					hash.put(access, result.getInt("count"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return hash;
	}

	@Override
	public HashMap<Access, Integer> get_short_access_count_by_user(String user_name) {
		HashMap<Access, Integer> hash = new HashMap<>();
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(GET_SHORT_ACCESS_COUNT_BY_USER)){
				
				statement.setString(1, user_name);
				
				var result = statement.executeQuery();
				
				
				while(result.next()) {
					Access access = new Access(result.getString("short_link"), result.getString("ip"));
					
					hash.put(access, result.getInt("count"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return hash;
	}

}
