package com.highradius;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.google.gson.Gson;

/**
 * Servlet implementation class DbConnection
 */
@WebServlet("/DbConnection")
public class DB_Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DB_Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HashMap<Object,Object> Response=new HashMap<Object,Object>();
	    ArrayList<pojo> list=new ArrayList<pojo>();
		
		try 
		{    
		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","@VIKash88044");
			PreparedStatement ps=connection.prepareStatement("Select * from winter_internship limit 100");
			//ps.setInt(1,id);  
			ResultSet rs=ps.executeQuery();
			while(rs.next())  
			{ 
				pojo x=new pojo();
				x.setSl_no(rs.getInt("sl_no"));
				x.setBuisness_year(rs.getString("buisness_year"));
				x.setBaseline_create_date(rs.getString("baseline_create_date"));
				x.setBusiness_code(rs.getString("business_code"));
				x.setClear_date(rs.getString("clear_date"));
				x.setCust_number(rs.getInt("cust_number"));
				x.setCust_payment_terms(rs.getString("cust_payment_terms"));
				x.setDoc_id(rs.getString("doc_id"));
			    x.setDocument_create_date(rs.getString("document_create_date"));
				x.setDocument_type(rs.getString("document_type"));
				x.setDue_in_date(rs.getString("due_in_date"));
				x.setInvoice_currency(rs.getString("invoice_currency"));
				x.setInvoice_id(rs.getInt("invoice_id"));
				x.setPosting_date(rs.getString("posting_date"));
				x.setPosting_id(rs.getString("posting_id"));
				x.setTotal_open_amount(rs.getFloat("total_open_amount"));
								
				//Pojo.add(x);
				list.add(x);
			}
			
			//Response.put("pojo",list);
			PrintWriter out=response.getWriter();
		}
		
		catch(Exception e) 
		  {e.printStackTrace();
		  }
		
		Gson gson = new Gson();
		
		String mytableJson = gson.toJson(list);
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		response.getWriter().append(mytableJson);
			
		
		
	}

	 /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}