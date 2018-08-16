package com.jda.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.dao.RegisterDao;
import com.jda.model.Register;


public class RegisterServlet  extends HttpServlet {
/**
	 * 
	 */
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */

public RegisterServlet(){
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	//Copying all the input parameters in to local variables

	 String fullName = request.getParameter("fullName");
	 String email = request.getParameter("email");
	 String userName = request.getParameter("userName");
	 String password = request.getParameter("password");
	 
	 Register register = new Register();
	 //Using Java Beans - An easiest way to play with group of related data
	 register.setFullName(fullName);
	 register.setEmail(email);
	 register.setUserName(userName);
	 register.setPassword(password); 
	 
	 RegisterDao registerDao = new RegisterDao();
	 
	 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
	 String userRegistered;
	try {
		userRegistered = registerDao.registerUser(register);
		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("login.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("register.jsp").forward(request, response);
		 }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	 }
}

