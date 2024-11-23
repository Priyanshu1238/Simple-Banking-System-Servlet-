package com.bank.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/enquiry")
public class Enquiry extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=resp.getWriter();
		out.println("Enquiry page");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system","root","Arun@2001");
			
			 HttpSession session=req.getSession();  
		    long sk1=(long)session.getAttribute("session_key");
		    
		    
		    
		    
			PreparedStatement ps=con.prepareStatement("select amount from bank_record where acountnumber=?");
			ps.setLong(1, sk1);
			ResultSet s=ps.executeQuery();
			long val=0l;
			
			if(s.next()) {
				val=s.getLong("amount");
			}			
			
			req.setAttribute("myname",val);
			req.getRequestDispatcher("enquiry.jsp").forward(req, resp);
			
			
				
			
			
		}
		
		
		
		
		
		
		catch(Exception e) {
			out.print(e.getMessage());
		}
		
		
		
		
		
		
		
		
	}

}
