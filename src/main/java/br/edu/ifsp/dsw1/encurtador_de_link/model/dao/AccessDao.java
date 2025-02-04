package br.edu.ifsp.dsw1.encurtador_de_link.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Access;
import br.edu.ifsp.dsw1.encurtador_de_link.model.entity.Link;

public interface AccessDao {
	boolean insert(Access access);
}
