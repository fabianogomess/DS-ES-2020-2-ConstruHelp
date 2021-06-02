package br.com.javatpoint.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.javatpoint.factory.ConnectionFactory;

public class ProjetoDAO {

private Connection con;
	
	public ProjetoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

}
