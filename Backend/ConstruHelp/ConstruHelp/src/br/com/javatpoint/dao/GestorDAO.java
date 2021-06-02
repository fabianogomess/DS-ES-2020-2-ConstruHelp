package br.com.javatpoint.dao;
import java.sql.Connection;
import br.com.javatpoint.factory.ConnectionFactory;

public class GestorDAO {

private Connection con;
	
	public GestorDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
}
