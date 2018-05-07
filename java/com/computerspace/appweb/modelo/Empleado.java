package com.computerspace.appweb.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {

		@Id
		private String email;
		@Column
		private String nombre;
		@Column
		private String apellidos;
		@Column
		private String password;	
		@Column
		private Long permiso;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Long getPermiso() {
			return permiso;
		}
		public void setPermiso(Long permiso) {
			this.permiso = permiso;
		}
		public Empleado () {
			super ();
		}
		
		public Empleado(String email, String nombre, String apellidos, String password, Long permiso) {
			super();
			this.email = email;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.password = password;
			this.permiso = permiso;
		}	
		
		
}
