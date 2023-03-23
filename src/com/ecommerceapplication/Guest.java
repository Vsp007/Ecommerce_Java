package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guest {

	private Connection connection;

	public void Guest() throws SQLException {
        //connection = DriverManager.getConnection(url, user, password);
        Connection connection = CommonConnection.getConnection();
    }
	/*
	public void createProductTable() {
		// Create a statement
        Statement stmt;
		try {
			stmt = connection.createStatement();
			
			 // Execute the SQL command to create the table
	         String sql = "CREATE TABLE "+Constants.TABLE_PRODUCTS+" (" +
	                      "product_id INT NOT NULL AUTO_INCREMENT," +
	                      "product_name VARCHAR(255) NOT NULL," +
	                      "product_description VARCHAR(255)," +
	                      "amount DOUBLE," +
	                      "PRIMARY KEY (product_id))";
	         stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public void insertDataInProductTable() {
		//Create a statement
		Statement stmt;
		try {
			stmt = connection.createStatement();
			// Execute the SQL command to insert the data
	        String sql = "INSERT INTO " + Constants.TABLE_PRODUCTS +
	                     " (product_id, product_name, product_description, amount) " +
	                     "VALUES ('\" + LG (32 inch) HD Ready LED Smart TV + \"', '\" + OS: WebOS, Full HD Ready 1366 x 768 pixels + \"', \" + 12,999 + \"\r\n" + 
	                     "\r\n" + 
	                     " )";
			
	                     stmt.executeUpdate(sql);
	                     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

    public void viewAllItem() throws SQLException {
    	String query="Select productId,productName,description,quantity,rice from viewproduct";
       
	PreparedStatement pstmt= connection.prepareStatement(query);
       ResultSet rs=pstmt.executeQuery();
       while(rs.next())
       {
    	   System.out.println("Product id:-"+rs.getInt(1));
    	   System.out.println("Product Name:-"+rs.getString(2));
    	   System.out.println("Product Description:-"+rs.getString(3));
    	   System.out.println("Quantity:-"+rs.getInt(4));
    	   System.out.println("Price :-"+rs.getInt(5));
    	   
       }
       

        

        
    }

    public void viewProductDetails(int id) throws SQLException {
        
		PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM viewproduct WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet resultset = pstmt.executeQuery();

        if (resultset.next()) {
        	String name=resultset.getString("ProductsName");
            String desc = resultset.getString("Description");
           
            int quantity = resultset.getInt("Quantity");
            int price=resultset.getInt("Price");

            System.out.println("Product ID: " + id);
            System.out.println("Product Name: " + name);
            System.out.println("Product Description: " + desc);
            System.out.println("Amount: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println();
        } else {
            System.out.println("Product not found.");
        }

        resultset.close();
        pstmt.close();
    }

    public void notPurchaseProduct(int id) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("DELETE FROM viewproduct WHERE id = ?");
        pstmt.setInt(1, id);
        int rowsDeleted = pstmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }

        pstmt.close();
    }

    public void close() throws SQLException {
        connection.close();
    }



}
