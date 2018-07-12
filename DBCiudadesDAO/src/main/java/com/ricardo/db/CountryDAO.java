package com.ricardo.db;

import java.util.List;

import com.ricardo.models.Country;

public abstract class CountryDAO extends DAO{

	protected CountryDAO() throws Exception {
		super();
	}
	
	public abstract List<Country> getLista();
	
}
