package org.jcaro.hibernateapp.services;

import java.util.List;
import java.util.Optional;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.repositories.ClienteRepositories;

import jakarta.persistence.EntityManager;

public class ClienteServicesImp implements ClienteServices{
	
	EntityManager em;
	ClienteRepositories repository;

	public ClienteServicesImp(EntityManager em) {
		
		this.em = em;
		repository = new ClienteRepositories(em);
	}

	@Override
	public List<Cliente> listar() {
		
		return repository.listar();
	}

	@Override
	public Optional<Cliente> porId(Integer id) {
		
		return Optional.ofNullable(repository.porId(id));
	}
	

	@Override
	public void guardar(Cliente cliente) {
		
		try {
			
			em.getTransaction().begin();
			repository.guardar(cliente);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(Integer id) {
		
		try {
			
			em.getTransaction().begin();
			repository.eliminar(id);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}


}
