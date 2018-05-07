package com.computerspace.appweb;

public class DataCliente {
	private long idcliente; 
	private String nombre;
	private String apellido;
	private DataLogin dataLogin;
	
	
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
	public DataLogin getDataLogin() {
		return dataLogin;
	}
	public void setDataLogin(DataLogin dataLogin) {
		this.dataLogin = dataLogin;
	}
	public long getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}
	
	
}
