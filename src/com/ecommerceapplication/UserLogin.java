package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	
	String userName;
	String password;
	public void userLogin() {
		
		System.out.println("User Login");
	}

	
	public  void getLoginDetails() {
		
		
		
		
	
		try {
			Connection con=CommonConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from registration where username=? and password=?");
		
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Login Successfully...");
			}
			else {
				System.out.println("Invalid Username and password...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

}
}