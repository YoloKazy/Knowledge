package com.ricardo.models;

import java.util.Hashtable;

public class Usuario {
	private String nombre;
	private String email;
	private String password;
	private int edad;
	private int sexo;
	
	public Usuario(String nombre, String email, String password, int edad, int sexo) {		
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.edad = edad;
		this.sexo = sexo;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public Hashtable validar() {
		Hashtable errors = new Hashtable();
		boolean hayError = false;
		
		if (this.nombre == null || this.nombre.equals("")) {
			errors.put("nombre", "Debes indicar el nombre");
			hayError = true;
		}

		if (this.email == null || this.email.equals("")) {
			errors.put("email", "Debes indicar el email");
			hayError = true;
		}

		if (this.password == null || this.password.equals("")) {
			errors.put("pass", "Debes indicar el password");
			hayError = true;
		}

		if (this.edad < 14 || this.edad > 100) {
			errors.put("edad", "Debes indicar la edad entre 14 y 100");
			hayError = true;
		}

		if (this.sexo < 0 || this.sexo > 1) {
			errors.put("sexo", "Debes indicar el sexo: Hombre o Mujer");
			hayError = true;
		}
		
		errors.put("hayError", hayError);
		
		return errors;
	}
	
	
}
