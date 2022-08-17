package org.jcaro.hibernateapp.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "tbl_alumnos_cursos",joinColumns = @JoinColumn(name="id_alumno"),
	inverseJoinColumns = @JoinColumn(name="id_curso"),uniqueConstraints = @UniqueConstraint(columnNames = {"id_alumno","id_curso"}))
	private List<Curso> cursos;
	
	public Alumno() {
		this.cursos = new ArrayList<>();
	}
	
	
	public Alumno(String nombre, String apellido) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
	
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
		curso.getAlumnos().add(this);
		
	}
	
	public void removeCurso(Curso curso) {
		curso.getAlumnos().remove(this);
		this.cursos.remove(curso);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", cursos=" + cursos +"]";
	}
	

}
