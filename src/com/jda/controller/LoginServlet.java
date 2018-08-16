package com.jda.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.dao.LoginDao;
import com.jda.model.Login;
import com.jda.model.Register;

public class LoginServlet extends HttpServlet{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginServlet(){}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		

		String userName=request.getParameter("userName");
		
		String password=request.getParameter("password");
		
		Login login=new Login();
		
	login.setUserName(userName);
	login.setPassword(password);
	
	LoginDao loginDao=new LoginDao();
	
	String userValidate=loginDao.authenticateUser(login);
	if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
	 {
	 request.setAttribute("userName", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
	 request.getRequestDispatcher("home.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
	 }
	 else
	 {
	 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
	 request.getRequestDispatcher("login.jsp").forward(request, response);//forwarding the request
	 }
	
		}
	 }
