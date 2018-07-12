package com.ricardo.db;

public class CountryDAOFactory {
	
	public static final CountryDAO getDAO(String tipo) throws Exception {
		if (tipo.equals("mysql")) return CountryDAOMysql.getInstance();
		else if (tipo.equals("mongo")) return new CountryDAOMongo();
		else return null;
	}
	
}
