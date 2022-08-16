package org.jcaro.hibernateapp.repositories;

import java.util.List;

import org.jcaro.hibernateapp.entity.Cliente;

import jakarta.persistence.EntityManager;

public class ClienteRepositories implements CrudRepositories<Cliente>{
	
	EntityManager em;
	
	public ClienteRepositories(EntityManager em) {	
		this.em = em;
	}

	@Override
	public Cliente porId(Integer id) {
		
		return em.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> listar() {
	
		return em.createQuery("select c from Cliente c",Cliente.class).getResultList();
	}

	@Override
	public void guardar(Cliente cliente) {
		
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		}else {
			
			em.persist(cliente);
		}
		
	}

	@Override
	public void eliminar(Integer id) {

		em.remove(porId(id));
		
	}

}
