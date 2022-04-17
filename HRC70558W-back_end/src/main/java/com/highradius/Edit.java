package com.highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String number=request.getParameter("sl_no");
		String InvoiceCurrency=request.getParameter("Invoice_Currency");
		String CustomerPayementTerms=request.getParameter("Customer_payment_terms");
		try {
			HashMap<Object,Object> Response=new HashMap<Object,Object>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root", "@VIKash88044");
			PreparedStatement ps=con.prepareStatement("update winter_internship set invoice_currency=?,cust_payment_terms=? where sl_no=?");
			
			ps.setString(1, InvoiceCurrency);
			ps.setString(2, CustomerPayementTerms);
			ps.setString(3, number);
			
			int i=ps.executeUpdate();
			if(i>0) {
				Response.put("update", true);
			}
			else {
				Response.put("update",false);
			}
			Gson gson=new Gson();
			String jsonResponse=gson.toJson(Response);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(jsonResponse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}