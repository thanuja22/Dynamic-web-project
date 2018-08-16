package com.jda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jda.model.Register;
import com.jda.util.DBConnection;


public class RegisterDao {
	public String registerUser(Register register) throws ClassNotFoundException {
		String fullName = register.getFullName();
		String email = register.getEmail();
		String userName = register.getUserName();
		String password = register.getPassword();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String dbName=DBConnection.getDbName();
			String query = "insert into "+dbName+".users (fullName,Email,userName,password) values (?,?,?,?)"; 
	
			preparedStatement = con.prepareStatement(query); // Making use of
			                                                 // prepared statements
			                                                 // here to insert
			                                                 // bunch of data
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, password);

			int i = preparedStatement.executeUpdate();

			if (i != 0) // Just to ensure data has been inserted into the database
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Oops.. Something went wrong there..!"; // On failure, send a
		                                               // message from here.
	}
}
