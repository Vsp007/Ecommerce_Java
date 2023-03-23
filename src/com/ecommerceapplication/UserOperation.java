package com.ecommerceapplication;

import java.util.Scanner;

public class UserOperation {

	
	Scanner scanner=new Scanner(System.in);
	public void getUserDetails()
	{
		
		System.out.println("User Registration>>");
		System.out.println("User Login>>");
		
		System.out.println("Buy Product>>");
		System.out.println("View Cart>>");
		System.out.println("Purchase the item>>");
		System.out.println("---------------------------------------------------");
		
		System.out.println("Enter your choice >>");
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter userId >> ");
			int userId=sc.nextInt();
			System.out.println("Enter firstName >> ");
			 String firstName=sc.next();
			 System.out.println("Enter lastName >> ");
			 String lastName=sc.next();
			 System.out.println("Enter username >> ");
			 String username=sc.next();
			 System.out.println("Enter password >> ");
			String password=sc.next();
			 System.out.println("Enter city >> ");
			 String city=sc.next();
			 System.out.println("Enter mailId >> ");
			 String mailId=sc.next();
			 System.out.println("Enter mobileNumber >> ");
			 long mobileNumber=sc.nextLong();
		 
			
			UserRegistration user=new UserRegistration(userId, firstName, lastName, username, password, city, mailId, mobileNumber);
			user.getUserDetails();
			break;
			
		case 2:
			Scanner sc2=new Scanner(System.in);
			
			System.out.println("Enter UserName >> ");
			 username=sc2.next();
			System.out.println("Enter Password >> ");
			 password=sc2.next();
			UserLogin login=new UserLogin();
			login.getLoginDetails();
		case 3:
			
			User1.getProduct();
			break;
		case 4:
			User1.buyProduct();
			break;
		case 5:
			User1.viewCart();
			break;
			
		case 6:
			User1.purchase();
			break;
			
			
			
			
		}
		
	}
	public void getAdminDetails()
	{
		System.out.println("Add product item>>");
		System.out.println("Calculate Bill>>");
		System.out.println("Display amount to End User>>");
		System.out.println("Check Quantity>>");
		System.out.println("Check registered user>>");
		System.out.println("Check the particular user history>>");
		System.out.println("---------------------------------------------------");
				
		
	}
	public void getGuestDetails()
	{
		System.out.println("View product >>");
		System.out.println("Not purchase >>");
		System.out.println("---------------------------------------------------");
	}


	
	
	
	
	
	
}
