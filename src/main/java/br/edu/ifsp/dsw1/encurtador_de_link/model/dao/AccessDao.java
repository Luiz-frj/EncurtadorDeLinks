package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.util.HashMap;
import java.util.List;

import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access;

public interface AccessDao {
	boolean insert(Access access);
	List<Access> get_all_by_user(String user_name);
	HashMap<Access, Integer> get_access_ip_count_by_short(String short_link);
	HashMap<Access, Integer> get_short_access_count_by_user(String user_name);
}
