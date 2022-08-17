package org.jcaro.hibernateapp;

import org.jcaro.hibernateapp.entity.Alumno;
import org.jcaro.hibernateapp.entity.Curso;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToMany {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Alumno alumno1 = new Alumno("Luisa", "Ospino");
			Alumno alumno2 = new Alumno("Luis", "Coneo");
			
			Curso curso1 = new Curso("Java", "Andres");
			Curso curso2 = new Curso("Java - Hibernate -JPA", "Andres");
			
			alumno1.getCursos().add(curso1);
			alumno1.getCursos().add(curso2);
			
			alumno2.getCursos().add(curso1);
			
			em.persist(alumno1);
			
			em.persist(alumno2);
			
			em.getTransaction().commit();
			
			System.out.println(alumno1);
			System.out.println(alumno2);
			
			em.getTransaction().begin();
			
			Curso c3 = em.find(Curso.class, 3L);
			alumno1.getCursos().remove(c3);
			
			em.getTransaction().commit();
			System.out.println(alumno1);
			
		} catch (Exception e) {
			
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
