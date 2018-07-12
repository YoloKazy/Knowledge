package com.ricardo.app;

import com.ricardo.models.Cliente;
import com.ricardo.models.Envio;
import com.ricardo.models.Item;
import com.ricardo.models.Pedido;
import com.ricardo.storage.Almacen;

public class TiendaApp {

	public static void main(String[] args) {
		Almacen miAlmacen=new Almacen();
		miAlmacen.showItems();
		
		Cliente yo = new Cliente(2345, "ricardo@r.cat");
		Pedido miPedido= new Pedido(23456, yo);
		
		Item otroItem=null;
		for (int i = 0; i < 10; i+=2) {
			otroItem=miAlmacen.getItem(i);
			if(otroItem!=null) miPedido.addItem(otroItem);	
		}
		
		miPedido.showItems();
		
		Envio miEnvio= new Envio("Direccion de mi casa", miPedido);
		miEnvio.enviar(miAlmacen);
		
		miAlmacen.showItems();
		
	}

}
