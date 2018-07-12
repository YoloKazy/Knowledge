package com.ricardo.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {

	protected static String url = null;
	protected DataSource datasource;

	protected DAO() throws Exception {

		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		this.datasource = (DataSource) envContext.lookup("jdbc/reservas");

	}

}
