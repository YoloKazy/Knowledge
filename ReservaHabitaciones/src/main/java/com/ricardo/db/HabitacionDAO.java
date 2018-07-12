package com.ricardo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ricardo.models.Habitacion;

public class HabitacionDAO extends DAO {

	private static HabitacionDAO instance = null;

	public static HabitacionDAO getInstance() throws Exception {
		if (instance == null)
			instance = new HabitacionDAO();

		return instance;
	}

	private HabitacionDAO() throws Exception {
	}

	public Habitacion getHabitacion(int hid) {
		Habitacion unaHabit = null;
		try {
			Connection conn = datasource.getConnection();

			String query = ("SELECT * FROM habitacion WHERE hid=?");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, hid);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				unaHabit = new Habitacion(rs.getInt("hid"), rs.getString("direccion"), rs.getDouble("ppd"));

				break;
			}

			stmt.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return unaHabit;
	}
}
