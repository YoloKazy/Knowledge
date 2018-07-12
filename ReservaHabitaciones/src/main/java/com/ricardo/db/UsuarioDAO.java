package com.ricardo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ricardo.models.Habitacion;
import com.ricardo.models.Reserva;
import com.ricardo.models.Usuario;

public class UsuarioDAO extends DAO {

	private static UsuarioDAO instance = null;

	public static UsuarioDAO getInstance() throws Exception {
		if (instance == null)
			instance = new UsuarioDAO();

		return instance;
	}

	private UsuarioDAO() throws Exception {
	}

	
	public Usuario getUsuario(int uid) {
		Usuario unUser = null;
		try {
			Connection conn = datasource.getConnection();

			String query = ("SELECT * FROM usuario WHERE uid=?");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, uid);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				unUser = new Usuario(rs.getInt("uid"),rs.getString("name"),rs.getString("email"));

				break;
			}

			stmt.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return unUser;
	}
}
