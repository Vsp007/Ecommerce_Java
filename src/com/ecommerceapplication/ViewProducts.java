package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewProducts {
	
	private int productId;
	private String productName;
	private String description;
	
	private int quantity;
	private double price;
	
	public ViewProducts(int productId, String productName, String description, int quantity, double price) throws ClassNotFoundException  {
		
		Connection con=null;
	     Statement stmt = null;
	     ResultSet rs = null;
	     
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Mysql@1234");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from viewproduct");
	         
	         while (rs.next()) {
	             productId =rs.getInt("productId");
	             productName = rs.getString("productName");
	             description=rs.getString("description");
	             quantity = rs.getInt("quantity");
	             price = rs.getDouble("price");
	         }
	         
	            System.out.println(" ProductId>> "+productId + "\n Product name>>" + productName + "\n Product description>>"+ description + "\n quantity>> " + quantity+"Price>>"+ price );
	            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         
         
	}

}
