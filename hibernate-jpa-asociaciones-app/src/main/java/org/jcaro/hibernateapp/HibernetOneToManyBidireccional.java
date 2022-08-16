package org.jcaro.hibernateapp;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.entity.Factura;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernetOneToManyBidireccional {
	public static void main(String[] args) {
		
		EntityManager em  = JpaUtil.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Cliente cliente = new Cliente("Luisa","Ospino");
			cliente.setFormaDePago("paypal");
			
			Factura f1 = new Factura("Electrodomesticos",1000L);
			Factura f2 = new Factura("Equipos de computo", 3000L);
			
			cliente.addClientes(f1).addClientes(f2);

			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
