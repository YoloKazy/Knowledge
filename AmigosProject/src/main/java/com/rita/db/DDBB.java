package com.rita.db;

import java.util.ArrayList;
import java.util.List;

import com.rita.models.Amigo;

public class DDBB {
	private static DDBB instance = null;
	private static List<Amigo> listaAmigos = new ArrayList<>();

	public static final DDBB getInstance() {
		if (instance == null)
			instance = new DDBB();
		return instance;
	}

	private DDBB() {
		loadUsuario();
	}

	private static final boolean loadUsuario() {
		listaAmigos.add(new Amigo(1, "Erika Ulloa"));
		listaAmigos.add(new Amigo(2, "Margarita Coca"));
		listaAmigos.add(new Amigo(3, "Carla Franco"));
		listaAmigos.add(new Amigo(4, "Silvia Campos"));
		listaAmigos.add(new Amigo(5, "Agustin Blazquez"));
		listaAmigos.add(new Amigo(6, "Marta Franco"));
		listaAmigos.add(new Amigo(7, "Adriana Berrios"));
		listaAmigos.add(new Amigo(8, "Olga"));
		listaAmigos.add(new Amigo(9, "David Blazquez"));
		listaAmigos.add(new Amigo(10, "Yenny"));
		return true;
	}

	public final List<Amigo> getAmigos() {
		return listaAmigos;
	}

	public final boolean removeAmigos(int idAmigo) {
		boolean remove = false;
		for (int i = 0; i < listaAmigos.size(); i++) {
			if (listaAmigos.get(i).getIdAmigo() == idAmigo) {
				listaAmigos.remove(i);
				remove = true;
				break;
			}
		}
		return remove;
	}

	public final boolean updateAmigos(int idAmigo, int idValor) {
		boolean remove = false;
		for (int i = 0; i < listaAmigos.size(); i++) {
			if (listaAmigos.get(i).getIdAmigo() == idAmigo) {
				listaAmigos.get(i).setPuntuacion(idValor);
				remove = true;
				break;
			}
		}
		return remove;
	}

	public final Amigo getAmigo(int idAmigo) {
		Amigo unAmigo = null;
		for (Amigo amigo : listaAmigos) {
			if (amigo.getIdAmigo() == idAmigo) {
				unAmigo = amigo;
				break;
			}
		}
		return unAmigo;
	}

	public final Amigo AnadirAmigo(String nombreAmigo) {
		int id = listaAmigos.get(listaAmigos.size() - 1).getIdAmigo();
		Amigo nuevoAmigo = new Amigo(id + 1, nombreAmigo);
		listaAmigos.add(nuevoAmigo);
		return nuevoAmigo;
	}

	public boolean ActualizarAmigos(int id, String nombre, int puntuacion) {
		String regexNum=".?[0-9].?";
		boolean isOk = false;
		if (id > 0 && nombre != null && !nombre.equals("") && puntuacion > 0 && puntuacion < 6 && !nombre.toUpperCase().equals(nombre)) {
			if(!nombre.matches(regexNum)) {
				for (Amigo amigo : listaAmigos) {
					if (amigo.getIdAmigo() == id) {
						amigo.setNombre(nombre);
						amigo.setPuntuacion(puntuacion);
						int index = listaAmigos.indexOf(amigo);
						listaAmigos.set(index, amigo);
						isOk = true;
						break;
					}
				}
			}
			}

		return isOk;
	}

}
