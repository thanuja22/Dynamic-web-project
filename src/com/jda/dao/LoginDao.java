package com.jda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jda.model.Login;
import com.jda.model.Register;
import com.jda.util.DBConnection;

public class LoginDao {
	public String authenticateUser(Login login)
	 {
	 
	String userName = login.getUserName(); //Keeping user entered values in temporary variables.
	 String password = login.getPassword();
	 
	Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 
	String userNameDB = "";
	 String passwordDB = "";
	 
	try
	 {
	 con = DBConnection.createConnection();
	 statement = con.createStatement(); 
	 resultSet = statement.executeQuery("select userName,password from users"); 
	 while(resultSet.next()) // Until next row is present otherwise it return false
	 {
	  userNameDB = resultSet.getString("userName"); //fetch the values present in database
	  passwordDB = resultSet.getString("password");
	 
	   if(userName.equals(userNameDB) && password.equals(passwordDB))
	   {
	      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
	   }
	 }
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return "Invalid user credentials"; // Just returning appropriate message otherwise
	 }
}
