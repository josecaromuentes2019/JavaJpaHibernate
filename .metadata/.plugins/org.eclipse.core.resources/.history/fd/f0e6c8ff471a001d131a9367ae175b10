package org.jcaro.hibernateapp;

import java.util.Scanner;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateEliminar {
	
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite el numero de identificaciòn de Id a eliminar");
			Integer id = Integer.valueOf(scanner.nextInt());
			
			Cliente cliente = em.find(Cliente.class, id);
			
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

}
