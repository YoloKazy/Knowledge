package com.ricardo.models;

import com.ricardo.storage.Almacen;

public class Envio {
	private String direccionEnvio;
	private Pedido pedido;
	public Envio(String direccionEnvio, Pedido pedido) {
		super();
		this.direccionEnvio = direccionEnvio;
		this.pedido = pedido;
	}
	
	public boolean enviar(Almacen miAlm) {
		System.out.println("\nENVIO:");
		for (Item aItem : this.pedido.getItems()) {
			miAlm.sustraerItem(aItem.getId());
			System.out.println("Enviando...:"+aItem);
		}
		
		System.out.println("Pedido "+this.pedido+" enviado!!! :-D");
		return true;
	}
}
