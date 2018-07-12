package com.ricardo.database;

import java.util.ArrayList;
import java.util.List;

import com.ricardo.models.Articulo;
import com.ricardo.models.Usuario;

public class Database {
	private static Database Instancia = null;
	private static List<Articulo> listaArticulos = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();

	public static final Database getInstance() {
		if (Instancia == null)
			Instancia = new Database();
		return Instancia;
	}

	private Database() {
		loadArticulos();
		loadUsuarios();
	}

	private static final boolean loadArticulos() {
		listaArticulos.add(new Articulo(1, "ricardo", "Este es mi primer artículo. Que guay está"));
		listaArticulos.add(new Articulo(2, "ricardo", "Este es mi segundo artículo. Que guay está"));
		return true;
	}

	private static final boolean loadUsuarios() {
		listaUsuarios.add(new Usuario("renato", "r@e.cat", "xxx", 23, 1));
		listaUsuarios.add(new Usuario("maría", "m@e.cat", "yyyy", 18, 2));
		return true;
	}

	public final List<Articulo> getArticulos() {
		return listaArticulos;
	}

	public final boolean addArticulo(Articulo unArt) {
		return listaArticulos.add(unArt);
	}

	public final boolean updateArticulo(Articulo unArt) {
		for (Articulo articulo : listaArticulos) {
			if (articulo.getIda() == unArt.getIda()) {
				articulo.setComentarios(unArt.getComentarios());
				break;
			}
		}

		return true;
	}

	public final Articulo getArticulo(int ida) {
		Articulo unArt = null;
		for (Articulo articulo : listaArticulos) {
			if (articulo.getIda() == ida) {
				unArt = articulo;
				break;
			}
		}

		return unArt;
	}

	public Usuario getUsuario(String email, String pass) {
		Usuario unUsuario = null;
		for (Usuario user : listaUsuarios) {
			if (user.getEmail().equals(email) && user.getPassword().equals(pass)) {
				unUsuario = user;
				break;
			}
		}

		return unUsuario;
	}

	public static Usuario getUsuarioByEmail(String email) {
		Usuario unUsuario = null;
		for (Usuario user : listaUsuarios) {
			if (user.getEmail().equals(email)) {
				unUsuario = user;
				break;
			}
		}

		return unUsuario;
	}

	public static boolean addArticle(Articulo newArt) {
		if(newArt.getIda()==0) {
			newArt.setIda(listaArticulos.size()+1);
		}
		return listaArticulos.add(newArt);
	}


	public boolean updateUsuario(Usuario newU) {
		System.out.println("Entra:"+newU.getEmail());
		for (Usuario user : listaUsuarios) {
			if (user.getEmail().equals(newU.getEmail()) ) {
				listaUsuarios.remove(user);
				listaUsuarios.add(newU);
				//Usuario theUser=listaUsuarios.get(listaUsuarios.indexOf(user));
				//theUser=newU;
				break;
			}
		}
		
		return true;
	}

}
