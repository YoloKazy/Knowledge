package com.ricardo.db;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ricardo.utils.PropertyValues;

public class DAO {

	protected static String url = null;
	protected DataSource datasource;

	protected DAO() throws Exception {

		// Properties props = new PropertyValues().getPropValues();

		// Class.forName( props.getProperty("dbdriver") ).newInstance();
		// this.url="jdbc:mysql://localhost/world?user=root&password=root";
		// this.url=props.getProperty("url")+"/"+props.getProperty("database")+"?user="+props.getProperty("user")+"&password="+props.getProperty("password");

		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		this.datasource = (DataSource) envContext.lookup("jdbc/worlddb");

	}

}
