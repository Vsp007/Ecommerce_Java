package com.ecommerceapplication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class AddProductItem {
	
	   
		
		public static void addProduct(int productId,String productName,String description,int quantity,double price) {
			


	        Connection con;
			try {
				con = CommonConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into viewproduct(productId,productName,description,quantity,price)values(?,?,?,?,?)");
				ps.setInt(1, productId);
				ps.setString(2, productName);
				ps.setString(3, description);
				ps.setInt(4,quantity);
				ps.setDouble(5, price);
				
				ps.execute();
				
				System.out.println("Product added successfully!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
		public static void getProduct()
		{
			Scanner sc = new Scanner(System.in);
	        
	        System.out.print("Enter product Id: ");
	        int productId = sc.nextInt();
	        
	        System.out.print("Enter product name: ");
	        String productName = sc.next();
	        
	        System.out.print("Enter product description: ");
	        String description = sc.next();
	                
	        System.out.print("Enter product quantity: ");
	        int quantity = sc.nextInt();
	        
	        System.out.print("Enter product price: ");
	        double price = sc.nextDouble();
	        
	        addProduct(productId,productName,description,quantity,price);
		
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			AddProductItem.getProduct();
		}
}
