package org.jcaro.hibernateapp;

import java.util.List;
import java.util.Optional;

import org.jcaro.hibernateapp.entity.Cliente;
import org.jcaro.hibernateapp.services.ClienteServices;
import org.jcaro.hibernateapp.services.ClienteServicesImp;
import org.jcaro.hibernateapp.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class HibernateCrudServices {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		ClienteServices services = new ClienteServicesImp(em);
		
	    System.out.println("========= Listar ========");
	    List<Cliente> cliente = services.listar();
	    cliente.forEach(c -> System.out.println(c));
	    
	    System.out.println("========= Listar por Id ==========");
	    Optional<Cliente> optionalCliente = services.porId(1);
	    if(optionalCliente.isPresent()) {
	    	System.out.println(optionalCliente.get());
	    }
	    
	    System.out.println("========== Crear cliente ==========");
	    
	    Cliente c = new Cliente();
	    c.setNombre("Dina");
	    c.setApellido("Doe");
	    c.setFormaDePago("paypal");
	    
	    services.guardar(c);
	    services.listar().forEach(cli -> System.out.println(cli));
	    
	    System.out.println("========== Actualizar ==========");
	    
	    Integer id = c.getId();
	    optionalCliente = services.porId(id);
	    
	    /*if(optionalCliente.isPresent()) {
	    	c = optionalCliente.get();
	    	c.setFormaDePago("mercado libre");
	    	
	    	services.guardar(c);
	    	services.listar().forEach(cli -> System.out.println(cli));
	    }*/
	    
	    optionalCliente.ifPresent(cli -> {
	    	cli.setFormaDePago("mercado libre");
	    	services.guardar(cli);
	    	services.listar().forEach(cl -> System.out.println(cl));
	    });
	    
	    System.out.println("========== Eliminar ==========");
	    
	    optionalCliente = services.porId(id);
	    
	    optionalCliente.ifPresent(cli -> {
	    	services.eliminar(cli.getId());
	    	services.listar().forEach(cl -> System.out.println(cl));
	    });
	    
	    
	    em.close();
	    
	}
}
