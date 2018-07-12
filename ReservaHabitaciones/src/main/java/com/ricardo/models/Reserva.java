package com.ricardo.models;

public class Reserva {
	private int rid;
	private Usuario usuario;
	private Habitacion habitacion;
	private int estado;
	private int dias;
	private double precioTotal;
	
	public Reserva(int rid, Usuario usuario, Habitacion habitacion, int estado, int dias, double precioTotal) {
		super();
		this.rid = rid;
		this.usuario = usuario;
		this.habitacion = habitacion;
		this.estado = estado;
		this.dias = dias;
		this.precioTotal = precioTotal;
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	 
	 
}
