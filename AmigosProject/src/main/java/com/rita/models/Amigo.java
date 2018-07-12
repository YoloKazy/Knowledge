package com.rita.models;

public class Amigo {
	private int idAmigo;
	private String nombre;
	private int puntuacion;
	
	public Amigo(int idAmigo, String nombre ) {
	
		this.idAmigo = idAmigo;
		this.nombre = nombre;
	}
	public int getIdAmigo() {
		return idAmigo;
	}
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	

}
