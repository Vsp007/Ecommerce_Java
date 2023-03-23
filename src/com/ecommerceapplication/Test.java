package com.ecommerceapplication;

import java.util.Scanner;

public class Test {
	
	public static void selectChoice()
	{
		String username="select username from registartion";
		User1 us=new User1(1,username);
		
		System.out.println("Select your choice");
		Scanner sc=new Scanner(System.in);
		System.out.println("1.view Products 2.buy Product 3. view user History  ");
		int choice=sc.nextInt();
		
		
		if(choice==1)
		{
			us.getProduct();
			
		}
		if(choice==2)
		{
			
			us.buyProduct();
		}
		if(choice==3)
		{
			
			us.viewUserHistory();
		}
		
		

	}
	
	
	

	public static void main(String[] args)
	{
		
		selectChoice();
		
		
		
	}
	

	
	
	

}
