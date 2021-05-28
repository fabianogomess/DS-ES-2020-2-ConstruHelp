package br.com.javatpoint.factory;

	import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
	public class ConnectionFactory {
	public Connection con;
	public Connection getConnection() {
		 try {
			return con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_projeto","root","123");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
	}
}