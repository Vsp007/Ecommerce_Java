package com.ecommerceapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class User1 {
	
	private int userId=0;
	private static String userName=getUserName();
	
	
		
	public User1(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
		
			}

	
	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}




	static ArrayList<Product> listProduct=new ArrayList<>();//all shoping items
	
	
	static Scanner sc=new Scanner(System.in);
	
	static int quantity;
	
	static Test mainStart= new Test();
	private static int productId;
	public static void getProduct()
	{
		try {
			Connection con= CommonConnection.getConnection();
			
			PreparedStatement prps=con.prepareStatement("select * from viewproduct");
			
			ResultSet resultSet=prps.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("Product id>>"+resultSet.getInt(1));
				System.out.println("Product Name>>"+resultSet.getString(2));
				System.out.println("Description>>"+resultSet.getString(3));
				System.out.println("Quantity>>"+resultSet.getInt(4));
				System.out.println("Price>>"+resultSet.getInt(5));
				System.out.println("---------------------------------------------------");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	


	public static void buyProduct()
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("How many products do you want to buy");
		int numberofprod=sc.nextInt();
		
		
		for(int i=1;i<=numberofprod;i++)
		{
		System.out.println("Enter the productId to Buy ");
		int id=sc.nextInt();
		
		System.out.println("Enter the quantity");
		 int quantity=sc.nextInt();
		
		
		
		ResultSet resultSet=getProduct(productId);
		
		try {
			while(resultSet.next())
			{
				int id1=resultSet.getInt(1);
				String prName=resultSet.getString(2);
				String prDes=resultSet.getString(3);
				int prPrice=resultSet.getInt(4);
				
				Product prDetail=new Product(id1,prName,prDes,quantity,prPrice*quantity);
				listProduct.add(prDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		}
		
		/*System.out.println("Do you want to view cart yes/no");
		String view=sc.next();
		*/
		

		viewCart();
		
		
	}
	




public static ResultSet getProduct(int productId)
{
	ResultSet resultSet=null;
	try {
		Connection con= CommonConnection.getConnection();
		
		PreparedStatement prps=con.prepareStatement("select productId,ProductsName,description,price,quantity from viewproduct where productId=?");
		
		prps.setInt(1,productId);
		
		resultSet=prps.executeQuery();
		
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return resultSet;


}


	public static  void viewCart() 
	{
		System.out.println("items in your cart");
		for(Product productDetails: listProduct)
		{
			
			System.out.println("Product id="+productDetails.getPrId());
			System.out.println("Product Name="+productDetails.getPrName());
			System.out.println("Product Description="+productDetails.getPrDescription());
			System.out.println("Product Quantity="+productDetails.getPrQuantity());
			System.out.println("Product Price="+productDetails.getPrPrice());
			System.out.println("---------------------------------------------------");
		}
		
		
		System.out.println("Do you want to purchase these items? 1)yes/2) no");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			purchase();
		}
		else
			mainStart.selectChoice();
		
	}
	
	public static void purchase()
	{
		
		
		System.out.println("Billing Details >> ");
		int counter =0;
		int totalAmmount =0;
		
		Connection con;
		
		try {
			con = CommonConnection.getConnection();
		
		for(Product productDetails: listProduct)
		{
			ResultSet resultSet=getProduct(productDetails.getPrId());
			int dbQuantity=0;
			try {
				while(resultSet.next())
				{
					
					 dbQuantity=resultSet.getInt(5); 
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int finalQuantity=dbQuantity-productDetails.getPrQuantity();
			//System.out.println("final quantity" +finalQuantity);
			
			PreparedStatement prps=con.prepareStatement("update viewproduct set quantity=? where id=?");
			prps.setInt(1,finalQuantity);
			prps.setInt(2,productDetails.getPrId());
			prps.execute();
			
			//to calculate total ammount for billing
			totalAmmount=totalAmmount+productDetails.getPrPrice();
		
			//For Billing
			counter=counter+1;	
			
			System.out.println(counter+"  "+productDetails.getPrName()+"  "+productDetails.getPrQuantity());
			
			
			
			
		}
		
		
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Total Ammount = "+ totalAmmount);
		System.out.println("Thank You");
		
		
		
		//inserting data into userHistory
				userHistory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	




	public static void insertUserHistoryDb(String username,String purchaseDetails, int total_Amount) 
	{
		
		
		Connection con;
		try {
			con = CommonConnection.getConnection();
			PreparedStatement prps=con.prepareStatement("insert into userHistory(username,purchaseDetails,total_Amount)values(?,?,?)");
			prps.setString(1, username);
			prps.setString(2, purchaseDetails);
			prps.setInt(3,total_Amount);
			
			prps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("user history updated succefully");
		
		
		
		
	}
	
	
	
	public static void userHistory()
	{
			
		String username=getUserName();
		String purchaseDetailsString="";
		int totalAmount=0;
		for(Product productDetails:listProduct)
		{
			if(purchaseDetailsString.isEmpty())
			{
				purchaseDetailsString = productDetails.getPrName() + "-" + productDetails.getPrQuantity();
			}
			else
			{
			purchaseDetailsString=purchaseDetailsString + "," + productDetails.getPrName() + "-" + productDetails.getPrQuantity();  
			
			}
			
			totalAmount=totalAmount+productDetails.getPrPrice();
			
			
		}
		
		insertUserHistoryDb(username,purchaseDetailsString,totalAmount);
		

		
	}
	
	
	public void viewUserHistory()
	{
		System.out.println("Please enter username");
		String username=sc.next();
		
		
		Connection con;
try {
			con = CommonConnection.getConnection();
			PreparedStatement prps=con.prepareStatement("select purchaseDetails,total_Amount, from userHistory where username=? ");
			
			prps.setString(1,username);
			
			
			 ResultSet resultSet=prps.executeQuery();
			 
			 while(resultSet.next())
			 {
				 System.out.println("product items and Quantity-->" + resultSet.getString(1));
				 System.out.print("total amount-->" + resultSet.getInt(2));
				 
			 }
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
