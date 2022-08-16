package org.jcaro.hibernateapp;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.entity.ClienteDetalle;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateAsociacionOneToOne {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			Cliente cliente = new Cliente("Luisa", "Ospino");
			cliente.setFormaDePago("paypal");
			em.persist(cliente);
			
			ClienteDetalle detalle = new ClienteDetalle(true, 5000);
			em.persist(detalle);
			
			cliente.setDetalle(detalle);
			em.getTransaction().commit();
			System.out.println(cliente);
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

}
