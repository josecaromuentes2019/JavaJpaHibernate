package org.jcaro.hibernateapp;

import javax.swing.JOptionPane;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateEditar {
	
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			
			Integer id = Integer.valueOf(JOptionPane.showInputDialog(null,"Digite el Id de cliente a editar"));
			
			Cliente c = em.find(Cliente.class, id);
			c.setNombre(JOptionPane.showInputDialog(null,"Ingresar o editar el nombre",c.getNombre()));
			c.setApellido(JOptionPane.showInputDialog(null,"Ingresar o editar el apellido",c.getApellido()));
			c.setFormaDePago(JOptionPane.showInputDialog(null,"Ingresar o editar la forma de pago",c.getFormaDePago()));
			
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
			
			System.out.println(c);
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

}
