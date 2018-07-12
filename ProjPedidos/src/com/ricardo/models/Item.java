package com.ricardo.models;

public class Item {
	private int id;
	private String descripcion;
	private double precio;
	
	public Item(int id, String descripcion, double precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public String showDetails() {
		return this.id+"/"+this.descripcion+"/"+this.precio+"€";
	}

	public int getId() {
		return this.id;
	}
	
	
}
