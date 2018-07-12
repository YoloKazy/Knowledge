package com.ricardo.models;

public class Habitacion {
	private int hid; 
	private String direccion;
	private double precioDia;
	
	public Habitacion(int hid, String direccion, double precioDia) {
		super();
		this.hid = hid;
		this.direccion = direccion;
		this.precioDia = precioDia;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
	
	
	
}
