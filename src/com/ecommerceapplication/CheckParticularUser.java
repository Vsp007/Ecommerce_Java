package com.ecommerceapplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



public class CheckParticularUser {
	
	String firstName;
	String lastName;
	String city;
	String mailId;
	Long mobileNumber;
	
	 public UserRegistration getUsername(int userId) {
	
	  UserRegistration user=null;
	  
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Mysql@1234");
		 String query = "select * from registration where userId=?";
         PreparedStatement pstmt = con.prepareStatement(query);
         pstmt.setInt(1, userId);
         ResultSet rs = pstmt.executeQuery();

       while(rs.next()) {
      	firstName = rs.getString("firstName");
           lastName=rs.getString("lastName");
           
           city = rs.getString("city");
           mailId=rs.getString("mailId");
           mobileNumber=rs.getLong("mobileNumber");
       
       }
          System.out.println("firstName >> "+firstName + "\n lastName>>" + lastName  + "\n city>> " + city + "mailId>>"+ mailId+"mobileNumber>>"+mobileNumber );
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
		
		
		
	
	 
	 }

	
	
	

}
