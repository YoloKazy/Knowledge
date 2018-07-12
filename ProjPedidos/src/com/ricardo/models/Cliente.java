package com.ricardo.models;

public class Cliente {
	private int id;
	private String email;
	private double cartera;
	
	public Cliente(int id, String email) {
		this.id=id;
		this.email=email;
	}

	public double getCartera() {
		return cartera;
	}

	public void setCartera(double cartera) {
		this.cartera = cartera;
	}
	
	
}
