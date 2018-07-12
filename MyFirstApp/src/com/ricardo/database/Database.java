package com.ricardo.database;

import java.util.ArrayList;
import java.util.List;

import com.ricardo.modelos.Mensaje;

public class Database {
	private static Database Instancia=null;
	private static List<Mensaje> listaMensajes = new ArrayList<>();
	
	public static final Database getInstance() {
		if(Instancia == null) {
			Instancia=new Database();
			loadMessages();
		}
		return Instancia;
	}
	
	private static final boolean loadMessages() {
					
		listaMensajes.add(new Mensaje("Yo", "Pedrita", "Hola!"));
		listaMensajes.add(new Mensaje("Pedrita", "Yo", "Qué tal?"));
				
		return true;
	}
}
