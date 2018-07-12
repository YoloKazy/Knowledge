package com.ricardo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ricardo.models.Country;
import com.ricardo.models.Language;

public class CountryDAOMysql extends CountryDAO {

	private static CountryDAOMysql instance = null;
	
	public static CountryDAOMysql getInstance() throws Exception  {
		if(instance==null) instance= new CountryDAOMysql();
		
		return instance;
	}
	
	private CountryDAOMysql() throws Exception {		
	}

	public List<Country> getLista() {

		List<Country> resultado = new ArrayList<Country>();

		try {
			Connection conn = datasource.getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT c.Name,c.Code,cl.* FROM country c LEFT JOIN countrylanguage cl ON cl.CountryCode=c.Code");
			
			Country tempCountry=null;
			
			while (rs.next()) {
				if(tempCountry==null) {
					tempCountry=new Country(rs.getString("code"), rs.getString("name"));
					tempCountry.setLanguages(new ArrayList<Language>());
				}else if( !rs.getString("code").equals(tempCountry.getCode()) ) {
					resultado.add(tempCountry);
					tempCountry=new Country(rs.getString("code"), rs.getString("name"));
					tempCountry.setLanguages(new ArrayList<Language>());
				}
				
				tempCountry.getLanguages().add(
						new Language(
							rs.getString("language"), 
							rs.getString("isOfficial")!=null?rs.getString("isOfficial").equals("T"):false, 
							rs.getDouble("percentage")
						)
				);
				

			}

			stmt.close();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}
}
