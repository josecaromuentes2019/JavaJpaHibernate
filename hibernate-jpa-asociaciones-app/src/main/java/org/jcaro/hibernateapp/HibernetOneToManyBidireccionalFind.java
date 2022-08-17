package org.jcaro.hibernateapp;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.entity.Factura;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernetOneToManyBidireccionalFind {
	public static void main(String[] args) {
		
		EntityManager em  = JpaUtil.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Cliente cliente = em.find(Cliente.class, 1);
			
			Factura f1 = new Factura("Electrodomesticos",1000L);
			Factura f2 = new Factura("Equipos de computo", 3000L);
			
			cliente.addFactura(f1).addFactura(f2);

			//em.persist(cliente);
			em.getTransaction().commit();
			System.out.println(cliente);
			
			
			//eliminar factura
			em.getTransaction().begin();
			Factura f3 = em.find(Factura.class, 1L);
			cliente.getFacturas().remove(f3);
			f3.setCliente(null);
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
