package org.jcaro.hibernateapp;

import java.util.List;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernetResultListWhere {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Query query = em.createQuery("select c from Cliente c where c.formaDePago=?1",Cliente.class);	
		
		List<Cliente> cliente = query.setParameter(1, "debito").getResultList();
		
		cliente.forEach(c -> System.out.println(c));
		em.close();
	}
}
