package com.ricardo.db;

import java.util.ArrayList;
import java.util.List;

import com.ricardo.models.Amigo;

public class DDBB {
	private static DDBB instance=null;
	private static List<Amigo> listaAmigos=new ArrayList<>();
	
	public static DDBB getInstance() {
		if(instance==null)instance=new DDBB();
		return instance;
	}
	
	private DDBB(){
		loadAmigos();
	}
	
	private static boolean loadAmigos() {
		listaAmigos.add(new Amigo(1, "Pepe"));
		listaAmigos.add(new Amigo(2, "Rosa"));
		listaAmigos.add(new Amigo(3, "Juan"));
		listaAmigos.add(new Amigo(4, "María"));
		listaAmigos.add(new Amigo(5, "Rosa"));
		listaAmigos.add(new Amigo(6, "Juana"));
		listaAmigos.add(new Amigo(7, "Roberto"));
		
		System.out.println(listaAmigos);
		
		return true;
	}

	public final List<Amigo> getAmigos() {
		return listaAmigos;
	}

	public boolean deleteAmigos(int idAmigo) {
		boolean isOk=false;
		for (Amigo amigo : listaAmigos) {
			if(amigo.getId()==idAmigo) {
				isOk=listaAmigos.remove(amigo);
				break;
			}
		}
		return isOk;
	}

	public boolean updatePuntuacion(int idAmigo, int punt) {
		boolean isOk=false;
		for (Amigo amigo : listaAmigos) {
			if(amigo.getId()==idAmigo) {
				amigo.setPuntuacion(punt);
				int index=listaAmigos.indexOf(amigo);
				listaAmigos.set(index, amigo);
				isOk=true;
				break;
			}
		}
		return isOk;
	}

	public Amigo addAmigo(Amigo newAmigo) {
		
		if(newAmigo!=null) {
			if(newAmigo.getId()==0) newAmigo.setId(listaAmigos.size()+1);
			if(!listaAmigos.add(newAmigo)) return null;
		}else return null;

		return newAmigo;
		
	}
	
	
}














