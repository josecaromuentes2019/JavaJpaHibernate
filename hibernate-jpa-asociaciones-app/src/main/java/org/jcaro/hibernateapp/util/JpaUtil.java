package org.jcaro.hibernateapp.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	private static final EntityManagerFactory entityMnagamentFactory = builEntityManagamenFactori();
	
	private static EntityManagerFactory builEntityManagamenFactori() {
		return Persistence.createEntityManagerFactory("ejemploJPA");
	}
	
	public static EntityManager getEntityManager() {
		return entityMnagamentFactory.createEntityManager();
	}

}
