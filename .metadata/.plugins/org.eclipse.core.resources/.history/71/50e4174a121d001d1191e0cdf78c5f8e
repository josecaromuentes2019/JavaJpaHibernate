package org.jcaro.hibernateapp;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.entity.ClienteDetalle;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToOne {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			Cliente cliente = new Cliente("Luisa","Ospíno");
			cliente.setFormaDePago("paypal");
			
			ClienteDetalle detalle = new ClienteDetalle(true, 3000);
			detalle.setCliente(cliente);
			cliente.setDetalle(detalle);
			em.persist(cliente);
			em.getTransaction().commit();
			System.out.println(cliente);
			System.out.println(detalle);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.clear();
		}
	}

}
