package com.jda.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String host="jdbc:mysql://10.0.0.160/";
	private static final String dbName="db1000140";
	public static Connection createConnection() {
		Connection con = null;
	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://10.0.0.160/db1000140","u1000140","GNh8EWriY0");
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return con;
	}
	public static String getDbName() {
		return dbName;
	}
}
