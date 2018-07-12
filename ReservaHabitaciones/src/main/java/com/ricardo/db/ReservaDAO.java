package com.ricardo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ricardo.models.Reserva;

public class ReservaDAO extends DAO {

	private static ReservaDAO instance = null;

	public static ReservaDAO getInstance() throws Exception {
		if (instance == null)
			instance = new ReservaDAO();

		return instance;
	}

	private ReservaDAO() throws Exception {
	}

	
	public int add(Reserva reservaToAdd) {
		int resultId = 0;

		try {
			Connection conn = datasource.getConnection();
			String query = ("INSERT INTO reserva (usuario,habitacion,estado,dias,preciototal) VALUES (?,?,?,?,?)");

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, reservaToAdd.getUsuario().getUid());
			stmt.setInt(2, reservaToAdd.getHabitacion().getHid());
			stmt.setInt(3, reservaToAdd.getEstado());
			stmt.setInt(4, reservaToAdd.getDias());
			stmt.setDouble(5, reservaToAdd.getPrecioTotal());

			System.out.println("Query:" + stmt.toString());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

			while (rs.next()) {
				resultId = rs.getInt(1);
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultId;
	}	
}
