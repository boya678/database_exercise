package com.appgate.databaseexercise.connections;

import static com.appgate.databaseexercise.utils.Variables.DBNAME;
import static com.appgate.databaseexercise.utils.Variables.DBPASS;
import static com.appgate.databaseexercise.utils.Variables.DBURL;
import static com.appgate.databaseexercise.utils.Variables.DBUSER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionManager {

	private Connection conn;
	private static ConnectionManager connectionManager;
	
	public static ConnectionManager init() {
		if(connectionManager==null) {
			connectionManager=new ConnectionManager();
			return connectionManager;
		}
		return connectionManager;
	}
	
	public Connection getConnection() {
		return this.conn;
	}

	public void connect(Boolean flaginit) {
		
		String url = "jdbc:postgresql://" + DBURL + "/";
		if(!flaginit) {
			url=url+DBNAME;
		}
		Properties props = new Properties();
		props.setProperty("user", DBUSER);
		props.setProperty("password", DBPASS);
		props.setProperty("ssl", "false");
		try {
			this.conn = DriverManager.getConnection(url, props);
			System.out.println("Connected");
		} catch (SQLException e) {
			System.out.println("Not Connected");
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			
		}
	}

	public ResultSet executeStatement(String query) {
		try {
			Statement stmt = this.conn.createStatement();
			return stmt.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
