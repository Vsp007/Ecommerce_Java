package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Order {
	//int userId;
	int productId;
	String username;
	String description;
	String productName;
	int quantity;
	double price;
	
	
	public Order(int productId,String username,String description,String productName,int quantity,double price) {
		
		Connection con;
		try {
			
			con = CommonConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into orderproduct(productId,username,description,productName,quantity,price)values(?,?,?,?,?,?)");
			ps.setInt(1, productId);
			//ps.setInt(2,userId);
			ps.setString(2, username);
			ps.setString(3, description);
			ps.setString(4, productName);
			ps.setInt(5, quantity);
			ps.setDouble(6, price);
			
			
			ps.execute();
			System.out.println("Product item has been added to cart..."); 
					
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
