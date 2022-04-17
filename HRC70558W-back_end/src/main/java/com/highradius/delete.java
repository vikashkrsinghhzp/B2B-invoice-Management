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
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HashMap<Object,Object> Response=new HashMap<Object,Object>();
	    ArrayList<pojo> Pojo=new ArrayList<pojo>();
		
		try 
		
	{  String Delete=request.getParameter("sl_no");
		System.out.println(Delete);
			
		String sql="DELETE from winter_internship where sl_no in (?)";
		
		
		
			
		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","@VIKash88044");
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, Delete);
			
		
			if(ps.executeUpdate()>0)
			{
				Response.put("delete",true);
			}
			
			else {
				Response.put("delete",false);
			    }
			Gson gson = new Gson();
			
			String mytableJson = gson.toJson(Response);
			//response.setHeader("Access-Control-Allow-Origin", "*");
			
			response.getWriter().append(mytableJson);
			
		}
		
		catch(Exception e) 
		  {e.printStackTrace();
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
