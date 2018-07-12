package com.ricardo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ricardo.models.City;
import com.ricardo.models.Country;

public class CiudadesDAO extends DAO {

	private static CiudadesDAO instance = null;

	public static CiudadesDAO getInstance() throws Exception {
		if (instance == null)
			instance = new CiudadesDAO();

		return instance;
	}

	private CiudadesDAO() throws Exception {
	}

	public List<City> getLista(String countryCode) {

		List<City> resultado = new ArrayList<City>();

		try {

			Connection conn = datasource.getConnection();//DriverManager.getConnection(url);

			String query = countryCode != null && !countryCode.equals("")
					? ("SELECT c.*,ct.* FROM city c LEFT JOIN country ct ON ct.Code=c.CountryCode WHERE c.CountryCode =? ORDER BY c.name")
					: ("SELECT c.*,ct.* FROM city c LEFT JOIN country ct ON ct.Code=c.CountryCode ORDER BY c.name");

			PreparedStatement stmt = conn.prepareStatement(query);
			if (countryCode != null && !countryCode.equals(""))
				stmt.setString(1, countryCode);

			ResultSet rs = stmt.executeQuery();
			
			City tempCity=null;

			while (rs.next()) {
				tempCity = new City(
						rs.getInt("id"), 
						rs.getString("c.name"),
						rs.getString("district"), 
						rs.getInt("population")
					);
				
				tempCity.setCountry( new Country(rs.getString("code"), rs.getString("ct.name")) );
				
				resultado.add(tempCity);
			}

			stmt.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public City getCity(String cityId) {
		City unaCiudad = null;
		try {
			Connection conn = datasource.getConnection();

			String query = ("SELECT * FROM city WHERE id=?");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, cityId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				unaCiudad = new City(rs.getInt("id"), rs.getString("name"),
						rs.getString("district"), rs.getInt("population")

				);

				break;
			}

			stmt.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return unaCiudad;
	}

	public boolean updateCity(City cityToUpdate) {

		boolean result = false;

		try {
			Connection conn = datasource.getConnection();

			String query = ("UPDATE city SET name=?,  district=?, population=? WHERE id=?");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, cityToUpdate.getName());
			stmt.setString(3, cityToUpdate.getDistrict());
			stmt.setInt(4, cityToUpdate.getPopulation());
			stmt.setInt(5, cityToUpdate.getId());

			int isOk = stmt.executeUpdate();

			result = true;

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int add(City cityToAdd) {
		int resultId = 0;

		try {
			Connection conn = datasource.getConnection();
			String query = ("INSERT INTO city (name,countryCode,district,population) VALUES (?,?,?,?)");

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, cityToAdd.getName());
			stmt.setString(3, cityToAdd.getDistrict());
			stmt.setInt(4, cityToAdd.getPopulation());

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

	public boolean deleteCity(int cid) {
		boolean result=false;
		try {
			Connection conn = datasource.getConnection();
			String query = ("DELETE FROM city WHERE id=?");
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, cid);
			stmt.executeUpdate();
			
			result=true;
			stmt.close();
			conn.close();
		} catch (Exception e) {

		}

		return result;
	}

	public int addCityAndCountry(City cityToAdd) throws SQLException {
		int resultId = 0;

		Connection conn = null;
		try {
			conn = datasource.getConnection();			
			conn.setAutoCommit(false);
			
			String queryp="INSERT INTO country (code,name,continent,region,surfacearea,population,localname,governmentform,code2) VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmtp = conn.prepareStatement(queryp);
			stmtp.setString(1, cityToAdd.getCountry().getCode());
			stmtp.setString(2, cityToAdd.getCountry().getName());
			stmtp.setString(3, "Oceania");
			stmtp.setString(4, "LATAM");
			stmtp.setFloat(5,1000000);
			stmtp.setInt(6,100000);
			stmtp.setString(7,"my-my");
			stmtp.setString(8,"Dictatorship");
			stmtp.setString(9,"MY");
			
			stmtp.executeUpdate();
			
			System.out.println("Primer insert bien!!");
					
			String query = "INSERT INTO city (name,countryCode,district,population) VALUES (?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, cityToAdd.getName());
			stmt.setString(2, cityToAdd.getCountry().getCode());
			stmt.setString(3, cityToAdd.getDistrict());
			stmt.setInt(4, cityToAdd.getPopulation());
			System.out.println("Query:" + stmt.toString());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

			while (rs.next()) {
				resultId = rs.getInt(1);
			}
			
			conn.commit();

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

		return resultId;
	}

}
