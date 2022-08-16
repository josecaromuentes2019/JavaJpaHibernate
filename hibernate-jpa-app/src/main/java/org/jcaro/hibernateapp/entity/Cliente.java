package org.jcaro.hibernateapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column(name = "forma_pago")
	private String formaDePago;
	
	@Embedded
	private Auditoria auditoria = new Auditoria();
	
	public Cliente() {
	}

	public Cliente(Integer id, String nombre, String apellido, String formaDePago) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.formaDePago = formaDePago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", formaDePago=" + formaDePago
				+ ", createDate=" + auditoria.getCreateDate() + ", lastModifiedDate=" + auditoria.getLastModifiedDate() +"]";
	}
	
	

}
