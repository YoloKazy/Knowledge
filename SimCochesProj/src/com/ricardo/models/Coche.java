package com.ricardo.models;

public class Coche {
	private String marca;
	private String tipo;
	private int velocidad;
	private Rueda[] ruedas;

	public Coche(String marca, String tipo, int velocidad) {
		this.marca = marca;
		this.tipo = tipo;
		this.velocidad = velocidad;
	}

	public void setRuedas(Rueda[] lasRuedas) {
		this.ruedas = lasRuedas;
	}

	public double avanzar(int kilometers) {
		// X c/rueda pinchada, penalizar 10%: 0.1
		// X c/rueda rota, penalizar 20%: 0.2

		double penalizacion = 0;
		if (this.ruedas != null) {
			for (Rueda unaRueda : this.ruedas) {
				if (unaRueda.getEstado() == 0)
					penalizacion += 0.1;
				else if (unaRueda.getEstado() == 2)
					penalizacion += 0.2;
			}
		}else penalizacion=1;

		return (double) kilometers / (double) (velocidad * (1 - penalizacion));
	}

	public boolean parar() {
		return false;
	}

	public String showData() {
		return this.marca + "/" + this.tipo;
	}

	private double procesarFractalmenteVelocidad() {
		return 0;
	}

}
