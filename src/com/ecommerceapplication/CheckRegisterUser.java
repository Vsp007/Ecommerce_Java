package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckRegisterUser {
	String firstName;
	String lastName;
	  String userName;
	String city;
	String mailId;
	Long mobileNumber;

	 public void getUserByUsername() {
		
	     Statement stmt = null;
	     ResultSet rs = null;
		 
	  
	 
	  
	
		Connection con;
		try {
			con = CommonConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from registration ");
	         while(rs.next()) {
	        	firstName = rs.getString("firstName");
	             lastName=rs.getString("lastName");
	             userName=rs.getString("userName");
	             city = rs.getString("city");
	             mailId=rs.getString("mailId");
	             mobileNumber=rs.getLong("mobileNumber");
	         
	         }
	            System.out.println("firstName >> "+firstName + "\n lastName>>" + lastName  +"\n userName>>"+userName+ "\n city>> " + city + "mailId>>"+ mailId+"mobileNumber>>"+mobileNumber );
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
     		
	 }
	
	

}
