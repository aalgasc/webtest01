package com.computerspace.appweb.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long idclientes;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String email;
	@Column
	private String password;
	
	public long getIdclientes() {
		return idclientes;
	}
	public void setIdclientes(long idclientes) {
		this.idclientes = idclientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Cliente () {
		super ();
	}
	
	public Cliente(long idclientes, String nombre, String apellidos, String email, String password) {
		super();
		this.idclientes = idclientes;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
	}
	public Cliente(String nombre, String apellidos, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
	}

	@OneToMany (fetch=FetchType.EAGER, mappedBy="cliente", cascade = CascadeType.ALL)
	private Set<Comentario> comentarios;

	public Set<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}


