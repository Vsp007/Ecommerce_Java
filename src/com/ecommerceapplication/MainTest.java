package com.ecommerceapplication;

import java.util.Scanner;


import com.ecommerceapplication.AddProductItem;
import com.ecommerceapplication.UserLogin;
import com.ecommerceapplication.UserOperation;
import com.ecommerceapplication.UserRegistration;
import com.ecommerceapplication.ViewProducts;

public class MainTest {
	

	public static void main(String[]args)  {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to E-Commerce Based Application...");
		
		System.out.println("Enter your choice...");
		int number=sc.nextInt();
		
		
		switch(number)
		{
		case 1:
		{
			
			System.out.println("User");
			System.out.println("---------------------------------------------------");
			UserOperation user=new UserOperation();
			user.getUserDetails();
			
			
			break;
			

			
		}
		case 2:
		{
			
			System.out.println("Admin");
			
			UserOperation user=new UserOperation();
			System.out.println("---------------------------------------------------");
			user.getAdminDetails();

			break;
			
		}
		case 3:
		{
			System.out.println("Guest");
			System.out.println("---------------------------------------------------");
			UserOperation user=new UserOperation();
			user.getGuestDetails();
			break;
		}
			
		
		case 4:
		{
			Scanner sc1=new Scanner(System.in);
			System.out.println("Enter productId>>");
			int productId=sc1.nextInt();
			//System.out.println("Enter userId>>");
			//2
			//int userId=sc1.nextInt();
			System.out.println("Enter username>>");
			String username=sc1.next();
			System.out.println("Enter description>>");
			String description=sc1.next();
			System.out.println("Enter productName >>");
			String productName=sc1.next();
			System.out.println("Enter quantity>>");
			int quantity=sc1.nextInt();
			System.out.println("Enter price>>");
			double price=sc1.nextDouble();
			Order order=new Order(productId,username,description,productName,quantity,price);
		}
		
		
		
		
		
		
		case 5:
		{
			System.out.println("Enter id>>");
			 int productId=sc.nextInt();
			PurchaseProduct prod=new PurchaseProduct();
			prod.getProductById(productId);
			break;
			
		}
		
		case 6:
		{
			System.out.println("Enter productId>>");
			int productId=sc.nextInt();
			CheckQuantity quanti=new CheckQuantity();
			quanti.getQuatity(productId);
			break;
		}
	
		case 7:
		{
			System.out.println("Enter userId>>");
			int userId=sc.nextInt();
			CheckParticularUser particularuser=new CheckParticularUser();
			particularuser.getUsername(userId);
			break;
		}

		case 8:
		{
			CheckRegisterUser checkregister= new CheckRegisterUser();
			checkregister.getUserByUsername();
			break; 
		}
		
		
			
		}
	}
}
