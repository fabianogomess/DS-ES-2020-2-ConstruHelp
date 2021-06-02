package br.com.javatpoint.dao;
import java.sql.*;

import br.com.javatpoint.classes.*;
import br.com.javatpoint.factory.ConnectionFactory;

public class UsuarioDAO {
	private Connection con;
	
	public UsuarioDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Pessoa pessoa) {
		String sql = "INSERT INTO pessoa(nome, senha, cpf, email) VALUES(?,?,?,?)";
		
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
	
	public void excluir(String cpfA) {
		String sql = "DELETE FROM pessoa WHERE cpf = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpfA);
			stmt.execute();
			stmt.close();
		}catch(SQLException exclusao) {
			throw new RuntimeException(exclusao);
		}
	}
	
	public String cpfRetornado(String emailA, String senhaA) {
		String sql = "SELECT cpf FROM pessoa WHERE email = ? and senha = ?";
		String retorno = "";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, emailA);
			stmt.setString(2, senhaA);
			try (ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					retorno = rs.getString(1);
				}
			}
			stmt.setString(1, retorno);
		}catch(SQLException erroCPF) {
			throw new RuntimeException(erroCPF);
		}
		return retorno;
	}
	
	public boolean Login(String emailA, String senhaA) {
		try {
		String sql = "SELECT email, senha FROM pessoa WHERE email = ? and senha = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, emailA);
		stmt.setString(2, senhaA);
		ResultSet rs = stmt.executeQuery();
		boolean autentifica = false;
		
		while(rs.next() && !autentifica) {
			if(rs.getString("email").equals(emailA)) {
				if(rs.getString("senha").equals(senhaA)) {
					autentifica = true;
				}	
			}
		}
		return autentifica;
	}catch(SQLException loginError) {
		throw new RuntimeException(loginError);
	}
	}
	
	public void AlterarDadosNome(String cpfA, String nomeA) {
		String sql = "UPDATE pessoa SET nome = ? WHERE cpf=?";
		try {
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nomeA);
		stmt.setString(2, cpfA);
		stmt.execute();
		stmt.close();	
		}catch(Exception errorConsulta) {
			throw new RuntimeException(errorConsulta);
		}
	}
	
	public void AlterarDadosEmail(String cpfA, String emailA) {
		String sql = "UPDATE pessoa SET email = ? WHERE cpf=?";
		try {
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, emailA);
		stmt.setString(2, cpfA);
		stmt.execute();
		stmt.close();	
		}catch(Exception errorConsulta) {
			throw new RuntimeException(errorConsulta);
		}
	}
	
	public void AlterarDadosSenha(String cpfA, String senhaA) {
		String sql = "UPDATE pessoa SET senha = ? WHERE cpf=?";
		try {
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, senhaA);
		stmt.setString(2, cpfA);
		stmt.execute();
		stmt.close();	
		}catch(Exception errorConsulta) {
			throw new RuntimeException(errorConsulta);
		}
	}

}