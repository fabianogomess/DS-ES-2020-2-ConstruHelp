package br.com.javatpoint.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.javatpoint.classes.Projeto;
import br.com.javatpoint.classes.Endereco;
import br.com.javatpoint.classes.Fornecedor;
import br.com.javatpoint.classes.Gestor;
import br.com.javatpoint.factory.ConnectionFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProjetoDAO {

	private static ProjetoDAO instance;
	protected EntityManager bd;
	public static ProjetoDAO getInstance() {
		if(instance == null) {
			instance = new ProjetoDAO();
		}
	return instance;
	}
	public ProjetoDAO() {
		bd = getEntityManager();
	}
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("arq");
		if(bd == null) {
			bd = factory.createEntityManager();
		}
		return bd;
	}

	
	public void adicionaProjeto(Projeto projeto, Endereco endereco) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			bd.merge(projeto);
			bd.merge(endereco);
			bd.getTransaction().commit();
			bd.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adicionaGestorProj(Projeto projeto, Gestor gestor) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			projeto.setGestores(gestor);
			bd.merge(projeto);
			bd.getTransaction().commit();
			bd.close();
		}catch(Exception err) {
			throw new RuntimeException(err);
		}
	}

}
