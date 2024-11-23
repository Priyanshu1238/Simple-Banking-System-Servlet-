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



@WebServlet("/deposit")
public class deposit extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		out.println("deposit page");
		long d=Integer.parseInt(req.getParameter("deposit1"));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system","root","Arun@2001");
			
			HttpSession session=req.getSession();  
			long sk1=(long)session.getAttribute("session_key");
			
			
			PreparedStatement ps=con.prepareStatement("select amount from bank_record where acountnumber=?");
			ps.setLong(1, sk1);
			ResultSet s=ps.executeQuery();
			
			long val=0;
			if(s.next()) {
				val=s.getLong("amount");}
			long sum=d+val;
			
			//   update
			
			
			 Statement statement = con.createStatement();
			 int count = statement.executeUpdate("UPDATE bank_record SET amount =" + sum + " WHERE acountnumber=" + sk1);
			
			
			resp.setContentType("text/html");
			out.println("<h4>Desposit Successfully</h4>");
			RequestDispatcher rd=req.getRequestDispatcher("/mainoption.jsp");
			rd.include(req, resp);
			
			
			
			
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
		

	
	
	
	
	
	
	
	}
	
	
	
	

}
