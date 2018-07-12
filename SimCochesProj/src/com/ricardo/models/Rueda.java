package com.ricardo.models;

public class Rueda {
	private double diametro;
	private String marca;
	private int tipo;
	// 0: pinchada, 1: bien, 2: rota	
	private int estado;
	
	public Rueda(double diametro, String marca, int tipo, int estado) {
		this.diametro = diametro;
		this.marca = marca;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	public int getEstado() {
		return this.estado;
	}


	public double girar() {
		return Math.PI * this.diametro;
	}
	
}
