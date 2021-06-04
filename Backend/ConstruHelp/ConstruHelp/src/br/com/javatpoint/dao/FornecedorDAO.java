package br.com.javatpoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.javatpoint.classes.Fornecedor;
import br.com.javatpoint.factory.ConnectionFactory;

public class FornecedorDAO {

	private static FornecedorDAO instance;
	protected EntityManager bd;
	public static FornecedorDAO getInstance() {
		if(instance == null) {
			instance = new FornecedorDAO();
		}
	return instance;
	}
	
	public FornecedorDAO() {
		bd = getEntityManager();
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("arq");
		if(bd == null) {
			bd = factory.createEntityManager();
		}
		return bd;
	}
	
	public void adiciona(Fornecedor fornecedor) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			bd.merge(fornecedor);
			bd.getTransaction().commit();
			bd.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
