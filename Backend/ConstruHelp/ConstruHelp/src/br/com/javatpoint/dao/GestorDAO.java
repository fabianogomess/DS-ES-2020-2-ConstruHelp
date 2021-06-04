package br.com.javatpoint.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.javatpoint.classes.Gestor;
import br.com.javatpoint.classes.Pessoa;
import br.com.javatpoint.classes.Projeto;
import br.com.javatpoint.factory.ConnectionFactory;

public class GestorDAO {

private static GestorDAO instance;
protected EntityManager bd;
public static GestorDAO getInstance() {
	if(instance == null) {
		instance = new GestorDAO();
	}
return instance;
}

public GestorDAO() {
	bd = getEntityManager();
}

private EntityManager getEntityManager() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("arq");
	if(bd == null) {
		bd = factory.createEntityManager();
	}
	return bd;
}
	
	public void adiciona(Gestor gestor){
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			bd.merge(gestor);
			bd.getTransaction().commit();
			bd.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adicionarProj(Projeto projeto, Gestor gestor) {
		try {
			if(!bd.getTransaction().isActive()) {
				bd.getTransaction().begin();
			}
			gestor.adicionarProjeto(projeto);
			bd.merge(projeto);
			bd.getTransaction().commit();
			bd.close();
		}catch(Exception err) {
			throw new RuntimeException(err);
		}
	}

}
