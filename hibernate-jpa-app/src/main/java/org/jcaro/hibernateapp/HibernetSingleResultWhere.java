package org.jcaro.hibernateapp;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernetSingleResultWhere {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Query query = em.createQuery("select c from Cliente c where c.formaDePago=?1",Cliente.class);	
		query.setMaxResults(1);
		Cliente cliente = (Cliente) query.setParameter(1, "debito").getSingleResult();
		
		System.out.println(cliente);
		em.close();
	}
}
