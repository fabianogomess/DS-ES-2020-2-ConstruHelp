package br.com.javatpoint.dao;
import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.javatpoint.classes.*;
import br.com.javatpoint.factory.ConnectionFactory;

public class UsuarioDAO {
	
	private static UsuarioDAO instance;
	protected EntityManager bd;
	public static UsuarioDAO getInstance() {
		if(instance == null) {
			instance = new UsuarioDAO();
		}
	return instance;
	}
	
	public UsuarioDAO() {
		bd = getEntityManager();
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("arq");
		if(bd == null) {
			bd = factory.createEntityManager();
		}
		return bd;
	}

	public void adicionaPessoa(Pessoa pessoa) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			bd.merge(pessoa);
			bd.getTransaction().commit();
			bd.close();
		}catch(Exception e) {
			e.printStackTrace();
			bd.getTransaction().rollback();
		}
	}
	
	public boolean Login(Pessoa pessoa, String senha) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			pessoa = bd.find(Pessoa.class, pessoa.getCPF());
			if(pessoa != null) {
			boolean autentifica = false;
			if(pessoa.getSenha().equals(senha)) {
					autentifica = true;
					return autentifica;
				}	
			}
			bd.getTransaction().commit();
			bd.close();
	}catch(Exception loginError) {
		throw new RuntimeException(loginError);
	}
		return false;
}
	
	public Pessoa retorno(Pessoa pessoa, boolean b) {
		try {
			if(!bd.getTransaction().isActive()) {
			bd.getTransaction().begin();
			}
			pessoa = bd.find(Pessoa.class, pessoa.getCPF());
			bd.getTransaction().commit();
			bd.close();
			return pessoa;
		}catch(Exception err) {
			throw new RuntimeException(err);
		}
	}
	
	
	public void excluir(Pessoa pessoa) {
		
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			pessoa = bd.find(Pessoa.class, pessoa.getCPF());
			bd.remove(pessoa);
			bd.getTransaction().commit();
			bd.close();
		}catch(Exception exclusao) {
			throw new RuntimeException(exclusao);
		}
	}
	
	public void AlterarDadosNome(Pessoa pessoa, String nome) {
		try {
		if(!bd.getTransaction().isActive()) {
			bd.getTransaction().begin();
		}
		pessoa = bd.find(Pessoa.class, pessoa.getCPF());
		pessoa.setNome(nome);
		bd.merge(pessoa);
		bd.getTransaction().commit();
		bd.close();
		}catch(Exception errorConsulta) {
			throw new RuntimeException(errorConsulta);
		}
	}
	
	public void AlterarDadosEmail(Pessoa pessoa, String email) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			pessoa = bd.find(Pessoa.class, pessoa.getCPF());
			pessoa.setEmail(email);
			bd.merge(pessoa);
			bd.getTransaction().commit();
			bd.close();
			}catch(Exception errorConsulta) {
				throw new RuntimeException(errorConsulta);
			}
	}
	
	public void AlterarDadosSenha(Pessoa pessoa, String senha) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			pessoa = bd.find(Pessoa.class, pessoa.getCPF());
			pessoa.setSenha(senha);
			bd.merge(pessoa);
			bd.getTransaction().commit();
			bd.close();
			}catch(Exception errorConsulta) {
				throw new RuntimeException(errorConsulta);
			}
		}	

	}
	