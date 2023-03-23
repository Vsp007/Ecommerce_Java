package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {
	int userId;
	 String firstName;
	 String lastName;
	 String username;
	 String password;
	 String city;
	 String mailId;
	 long mobileNumber;
	 
	
	
	public UserRegistration(int userId,String firstName,String lastName,String username,String password,String city,String mailId,long mobileNumber) {
		
		super();
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.username=username;
		this.password=password;
		this.city=city;
		this.mailId=mailId;
		this.mobileNumber=mobileNumber;
		
		
	
		try {
			
			Connection con=CommonConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into registration(userId,firstname,lastname,username,password,city,mailId,mobileNumber)values(?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, userId);
			ps.setString(2, firstName);
			ps.setString(3,lastName);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setString(6, city);
			ps.setString(7, mailId);
			ps.setLong(8, mobileNumber);
			
			
			ps.execute();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void getUserDetails() {
		
		System.out.println("Inserted Successfully...");	
		}

	

}
