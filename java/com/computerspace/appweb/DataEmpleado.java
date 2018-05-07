package com.computerspace.appweb;

public class DataEmpleado {
	private String nombre;
	private String apellidos;
	private DataEmpleadoLogin dataEmpleadoLogin;
	private Long permiso;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellido(String apellidos) {
		this.apellidos = apellidos;
	}
	public DataEmpleadoLogin getDataEmpleadoLogin() {
		return dataEmpleadoLogin;
	}
	public void setDataEmpleadoLogin(DataEmpleadoLogin dataEmpleadoLogin) {
		this.dataEmpleadoLogin = dataEmpleadoLogin;
	}
	public Long getPermiso() {
		return permiso;
	}
	public void setPermiso(Long permiso) {
		this.permiso = permiso;
	}
	
	
}
