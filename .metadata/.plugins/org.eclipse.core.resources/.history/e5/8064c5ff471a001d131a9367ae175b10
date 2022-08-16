package org.jcaro.hibernateapp;

import javax.swing.JOptionPane;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateCrear {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			
			String nombre = JOptionPane.showInputDialog(null,"Digite un nombre");
			String apellido = JOptionPane.showInputDialog(null,"Digite un apellido");
			String formaDePafo = JOptionPane.showInputDialog(null,"Digite una forma de Pago");
			
			em.getTransaction().begin();
			
			Cliente c = new Cliente();
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setFormaDePago(formaDePafo);
			em.persist(c);
			em.getTransaction().commit();
			
			c = em.find(Cliente.class, c.getId());
			System.out.println(c);
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

}
