package com.ricardo.models;

public class Usuario {
	private int uid;
	private String nombre;
	private String email;
	
	public Usuario(int uid, String nombre, String email) {
		super();
		this.uid = uid;
		this.nombre = nombre;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
