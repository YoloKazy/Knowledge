package com.ricardo.app;

import com.ricardo.models.Coche;
import com.ricardo.models.Rueda;

public class MainProj {

	public static void main(String[] args) {
		Coche[] lista_coches = {
				new Coche("Alfa", "Deportivo", 120),
				new Coche("Rolls", "Classic", 150), 
				new Coche("Toyota", "4x4", 100)
			};
		
		
		Rueda[] lasRuedas= {
			new Rueda(21, "Firestone", 0, 0),
			new Rueda(21, "Firestone", 0, 1),
			new Rueda(21, "Firestone", 0, 1),
			new Rueda(21, "Firestone", 0, 2)
		};
		
		lista_coches[0].setRuedas(lasRuedas);
		
		System.out.println("El tiempo del Alfa:"+lista_coches[0].avanzar(100));
		
		Coche masRapido=null;
		int distancia=100;
		
		for (Coche unCoche : lista_coches) {
			if(masRapido==null) masRapido=unCoche;
			else if(unCoche.avanzar(distancia)<masRapido.avanzar(distancia)) masRapido=unCoche;
		}
		
		System.out.println("El más rápido es: "+ masRapido.showData());
	}

}
