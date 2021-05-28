package br.com.javatpoint.dao;
import java.sql.*;
import java.sql.PreparedStatement;
import br.com.javatpoint.classes.*;
import br.com.javatpoint.factory.ConnectionFactory;

import java.sql.Connection;

public class UsuarioDAO {
	private Connection con;
	
	public UsuarioDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Pessoa pessoa) {
		String sql = "INSERT INTO pessoa(Nome, Senha, cpf, Email) VALUES(?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSenha());
			stmt.setString(3, pessoa.getCPF());
			stmt.setString(4, pessoa.getEmail());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
