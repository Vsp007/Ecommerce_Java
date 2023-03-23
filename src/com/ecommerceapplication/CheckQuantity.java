package com.ecommerceapplication;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class CheckQuantity {
	int quantity;
	
	public AddProductItem getQuatity(int productId) {
		AddProductItem order=null;
		Connection con=null;
	     Statement stmt = null;
	     ResultSet rs = null;
	     
	     try {
			con = CommonConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from viewproduct where productId='?'");
	          
			int quantity=rs.getInt("quantity");
	        	
	         
	         
	            System.out.println("quantity>> " +quantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				return order;
		
		
	  }
		
		
}
