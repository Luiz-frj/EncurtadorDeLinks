package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.encurtador_de_link.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access;

class AccessDaoImpl implements AccessDao {
	private static final String INSERT = "INSERT INTO tb_access(link, ip) VALUES (?,?)";

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

}
