package com.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static DbConnection instance = new DbConnection();
	String user ="scott ";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String password ="tiger ";
	String driverClass="oracle.jdbc.driver.OracleDriver ";
	private DbConnection(){
		try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	 public static DbConnection getInstance()   {
	        return instance;
	    }
	 public Connection getConnection() throws SQLException, 
	    ClassNotFoundException {
	        Connection connection = 
	            DriverManager.getConnection(url, user, password);
	        return connection;
	    }   
}
