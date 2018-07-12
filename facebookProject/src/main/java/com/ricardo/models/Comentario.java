package com.ricardo.models;

public class Comentario {
	private String autor;
	private String comentario;
	
	public Comentario(String autor, String comentario) {
		super();
		this.autor = autor;
		this.comentario = comentario;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
