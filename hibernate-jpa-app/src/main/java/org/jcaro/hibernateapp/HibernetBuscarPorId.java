package org.jcaro.hibernateapp;

import java.util.Scanner;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernetBuscarPorId {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digita un id de cliente");
		Integer id = scanner.nextInt();
		EntityManager em = JpaUtil.getEntityManager();
		
		Cliente cliente = em.find(Cliente.class, id);		
		
		System.out.println(cliente);
		em.close();
	}
}
