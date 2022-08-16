package org.jcaro.hibernateapp;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.entity.Factura;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateAsociacionManyToOne {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		 
		 try {
			 
			 Cliente cliente = new Cliente("Luisa","Ospino");
			 cliente.setFormaDePago("paypal");
			 
			 em.getTransaction().begin();
			 em.persist(cliente);
			 Factura factuta = new Factura("Productos de Oficina",300L);
			 factuta.setCliente(cliente);
			 em.persist(factuta);
			 em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}

	
	}
	
	
		 

}
