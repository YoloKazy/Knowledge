package com.ricardo.models;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
	private int ida;
	private String usuario;
	private String texto;
	private List<Comentario> comentarios;
	
	public Articulo(int ida, String usuario, String texto) {
		this.ida=ida;
		this.usuario = usuario;
		this.texto = texto;
		this.comentarios=new ArrayList();
	}
	
	public int getIda() {
		return ida;
	}

	public void setIda(int ida) {
		this.ida = ida;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public boolean addComentario(Comentario newComment) {
		return this.comentarios.add(newComment);
	}
	
	
	
}
