package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.adminoperation.Product;

public class PurchaseProduct {
	//int userId;
	String username;
	String productName;
	String description;
	int quantity;
	double price;

	
	    private static final String URL = "jdbc:mysql://localhost:3306/Mysql@1234";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "Mysql@1234";

	    public Order getProductById(int productId) {
	        Order product = null;

	        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Mysql@1234")) {
	            String query = "SELECT * FROM orderproduct WHERE productId=?";
	            PreparedStatement pstmt = conn.prepareStatement(query);
	            pstmt.setInt(1, productId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	
	            
	                String productName = rs.getString("productName");
	                int quantity = rs.getInt("quantity");
	                String description = rs.getString("description");
	                double price = rs.getDouble("price");
	                
	                
	                

	                product = new Order( productId, username, description, productName, quantity, price);
	            }
	        
	    } catch (SQLException e) {
            e.printStackTrace();
        }

	     
	        return product;
	    }

		
		

		
}
