package br.com.javatpoint.factory;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.EntityTransaction;

import javax.persistence.Persistence;

public class PersistenceConfig {
	
	private static final EntityManagerFactory entity = Persistence.createEntityManagerFactory("arq");

	public static void main(String[] args) {
		inicializarBD();
	}
	
	private static void inicializarBD() {
		EntityManager entityManager = entity.createEntityManager();
		entityManager.close();
	}
}
