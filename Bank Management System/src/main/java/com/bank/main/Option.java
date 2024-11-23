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


@WebServlet("/Option")
public class Option extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,NumberFormatException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		//out.println("login page");
		long an=Long.parseLong(req.getParameter("accno"));
		int pc=Integer.parseInt(req.getParameter("pincode"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system","root","Arun@2001");
			PreparedStatement ps=con.prepareStatement("select * from bank_record");
			ResultSet s=ps.executeQuery();
			int check=0;
			String displayname=null;
			while(s.next()) {
				if(an==s.getLong("acountnumber") && pc==s.getInt("pincode") ) {
					check=1;
					displayname=s.getString("name");			
				}
				
			}
			if(check==1) {
//				PreparedStatement ps1=con.prepareStatement("select amount from bank_record where acc=?");
//				ps1.setInt(1, an);
//				ResultSet s1=ps1.executeQuery();
//				while(s1.next()) {
//					System.out.println(s1.getInt(amount));
//				}

				
				HttpSession session=req.getSession();
				session.setAttribute("session_key",an);
				session.setAttribute("key",displayname);
				RequestDispatcher rd=req.getRequestDispatcher("/mainoption.jsp");
				rd.forward(req, resp);
			}
			else {
				resp.setContentType("text/html");
			out.println("<h4>please give valid credentials</h4>");
			RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);}
			
			
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
		
		
		
		
		
	}

}
