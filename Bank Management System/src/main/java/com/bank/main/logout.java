package com.bank.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/logout")
public class logout extends HttpServlet {
  
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			
			HttpSession session = req.getSession();
			   session.invalidate();
			   
			   RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			   rd.forward(req, resp);
			   
			
			
			
			
		}
	
	
	
	
	
	
	
	
}
