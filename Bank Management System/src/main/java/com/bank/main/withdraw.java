package com.bank.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/withdraw")
public class withdraw extends HttpServlet {
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		out.println("Withdraw Page");
		long d=Long.parseLong(req.getParameter("withdraw1"));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system","root","Arun@2001");
			
			HttpSession session=req.getSession();  
		    Long sk1=(Long)session.getAttribute("session_key");
			
			
			PreparedStatement ps=con.prepareStatement("select amount from bank_record where acountnumber=?");
			ps.setLong(1, sk1);
			ResultSet s=ps.executeQuery();
			
			Long val=0l;
			if(s.next()) {
				val=s.getLong("amount");}
			
			
			if(d>val) {
				resp.setContentType("text/html");
				out.println("<h4>Insufficient Balance</h4>");
				RequestDispatcher rd=req.getRequestDispatcher("/mainoption.jsp");
				rd.include(req, resp);
			}
			
			
			
			else {
			Long sum=val-d;
			
			//   update
			
			
			 Statement statement = con.createStatement();
			 int count = statement.executeUpdate("UPDATE bank_record SET amount =" + sum + " WHERE acountnumber=" + sk1);
			
			
			resp.setContentType("text/html");
			out.println("<h4>withdraw Successfully</h4>");
			RequestDispatcher rd=req.getRequestDispatcher("/mainoption.jsp");
			rd.forward(req, resp);
			}
			
			
			
			
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
		

	
	
	
	
	}
	
	
	
	

}
