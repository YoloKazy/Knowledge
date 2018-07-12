package com.ricardo.modelos;

public class Mensaje {
	private String remitente;
	private String receptor;
	private String texto;
	
	public Mensaje(String remitente, String receptor, String texto) {
		this.remitente = remitente;
		this.receptor = receptor;
		this.texto = texto;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
}
