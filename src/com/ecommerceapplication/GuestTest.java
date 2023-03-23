package com.ecommerceapplication;

import java.sql.SQLException;

public class GuestTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Guest guest = new Guest();

	    // View all products
	   /* guest.createProductTable();
	    guest.insertDataInProductTable();*/
	    guest.viewAllItem();
	    guest.notPurchaseProduct(0);
	    // View
	
	
	}

}
